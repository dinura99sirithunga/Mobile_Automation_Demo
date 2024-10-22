package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import util.CommonOperations;
import util.ExtentTestNGReportBuilder;
import util.MobileCapabilityExtension;
import util.PropertyReader;

import java.net.MalformedURLException;
import java.net.URL;

public class baseConfig extends ExtentTestNGReportBuilder {
    public AppiumDriver<MobileElement> androidDriver;
    public CommonOperations commonOperations;
    PropertyReader propertyReader = new PropertyReader("application.properties");


    @BeforeTest
    @Parameters({"env"})
    public void setupTheApplication(String env) throws MalformedURLException, Exception {
        DesiredCapabilities dcap = new DesiredCapabilities();
        if (env.equalsIgnoreCase("Android")) {
            dcap.setCapability(MobileCapabilityExtension.PLATFORM_NAME, "Android");
            dcap.setCapability(MobileCapabilityExtension.DEVICE_NAME, propertyReader.get("Android.deviceName"));
            dcap.setCapability(MobileCapabilityExtension.UDID, propertyReader.get("Android.udid"));
            dcap.setCapability(MobileCapabilityExtension.PLATFORM_VERSION, propertyReader.get("Android.Version"));
            dcap.setCapability(MobileCapabilityExtension.appPackage, "com.sla.android.app");
            dcap.setCapability(MobileCapabilityExtension.appActivity, "com.example.sri_lankan_airlines.MainActivity");
            dcap.setCapability("appium:automationName", "uiAutomator2");
            dcap.setCapability("noReset", false);
            dcap.setCapability("appium:fullReset", false);
            androidDriver = new AppiumDriver<MobileElement>(new URL(propertyReader.get("Appium.URL")), dcap);
            androidDriver.setSetting("enforceXPath1",true);
            commonOperations = new CommonOperations(androidDriver);
        } else {
            System.out.println("Unknown App");
        }
    }

    @AfterClass
    public void endDriver() {
        androidDriver.quit();
    }
}
