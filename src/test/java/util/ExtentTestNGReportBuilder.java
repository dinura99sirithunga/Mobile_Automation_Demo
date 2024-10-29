package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

// Main class to build the ExtentReport for TestNG tests.
public class ExtentTestNGReportBuilder {

    // Define report output location and file name.
    private static final String OUTPUT_FOLDER = "reports/";
    private static final String FILE_NAME = "TestReport.html";

    // Static ExtentReports instance to avoid recreating the report object.
    private static ExtentReports extent;

    // Thread-local instances for parent and child test logging.
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    // PropertyReader instance for reading configuration values from properties file.
    PropertyReader propertyReader = new PropertyReader("propertyFile/baseConfig.properties");

    // Platform name fetched from properties to include in the report.
    public String platformName = propertyReader.get("platformName");

    @BeforeSuite
    // Set up the ExtentSparkReporter once before the test suite begins.
    public void beforeSuite() {
        // Configures the HTML report file location and theme.
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
        sparkReporter.config().setDocumentTitle("Web Driver I/O  Demo App"); // Set document title
        sparkReporter.config().setReportName("Practical Report"); // Set report name
        sparkReporter.config().setTheme(Theme.DARK); // Set report theme

        // Attach reporter and set environment/system information.
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("ENVIRONMENT", "Test");  // Set environment; can be dynamic
        extent.setSystemInfo("User", "Dinura Sirithunga"); // User running the tests
    }

    @BeforeTest
    // Initializes a parent test in the report for each TestNG test context.
    public synchronized void beforeTest(final ITestContext testContext) {
        // Creates a new test node for each test context (test class or suite).
        ExtentTest parent = extent.createTest(testContext.getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    // Sets up a child test node for each test method.
    public synchronized void beforeMethod(Method method) {
        // Creates a child node within the parent test for the test method.
        ExtentTest child = parentTest.get().createNode(method.getName());
        test.set(child);
    }

    @AfterMethod
    // Logs the result of each test method in the report.
    public synchronized void afterMethod(ITestResult result) {
        // Log status based on test result: pass, fail, or skip.
        if (result.getStatus() == ITestResult.FAILURE)
            test.get().fail(result.getThrowable().getLocalizedMessage()); // Log failure message
        else if (result.getStatus() == ITestResult.SKIP)
            test.get().skip(result.getThrowable().getLocalizedMessage()); // Log skip message
        else
            test.get().pass("Test Passed"); // Log pass message

        // Write results to the report.
        extent.flush();
    }
}
