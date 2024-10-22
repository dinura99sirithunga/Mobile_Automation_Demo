package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class ExtentTestNGReportBuilder {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    @BeforeSuite
    @Parameters({ "env" })
    public void beforeSuite(String env) {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
                TestConfiguration.OUTPUT_FOLDER + TestConfiguration.FILE_NAME);

        htmlReporter.config().setDocumentTitle("Srilanakan Airlines Health Checker Report");
        htmlReporter.config().setReportName("Regression Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("ENVIRONMENT", env);
        extent.setSystemInfo("User", "Dilip Vengadesan");
    }

    @BeforeTest
    public synchronized void beforeTest(final ITestContext testContext) {
        ExtentTest parent = extent.createTest(testContext.getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
        ExtentTest child = parentTest.get().createNode(method.getName());
        test.set(child);
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
            test.get().fail(result.getThrowable().getLocalizedMessage());
        else if (result.getStatus() == ITestResult.SKIP)
            test.get().skip(result.getThrowable().getLocalizedMessage());
        else
            test.get().pass("Test Passed");
        extent.flush();
    }
}
