package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

// Extends the ExtentTestNGReportBuilder class to include reporting functionality.
public class baseConfig extends ExtentTestNGReportBuilder {
    // Declaration of Appium driver for Android and a common operations utility.
    public AppiumDriver appiumDriver;
    public CommonOperations commonOperations;

    // PropertyReader instance to load properties from baseConfig.properties file.
    PropertyReader propertyReader = new PropertyReader("propertyFile/baseConfig.properties");

    // Path to the application under test, defined in the properties file.
    public String APP_PATH = Paths.get(System.getProperty("user.dir"), propertyReader.get("appPath")).toString();
    // Platform name, e.g., Android or iOS, fetched from properties file.
    public String platformName = propertyReader.get("platformName");

    @BeforeTest
    // Initializes the application setup before running tests
    public void setupTheApplication() throws MalformedURLException, Exception {
        // Desired capabilities used to specify device and application configuration.
        DesiredCapabilities dcap = new DesiredCapabilities();

        // Check if platform is Android (current implementation only configures for Android).
        if (platformName.equalsIgnoreCase("Android")) {
            // Set the app’s file path.
            dcap.setCapability("app", APP_PATH);
            // Define the platform name (Android) in the capabilities.
            dcap.setCapability(PLATFORM_NAME, platformName);

            // Set device-specific capabilities, such as device name, unique device identifier (UDID),
            // and Android platform version.
            dcap.setCapability("deviceName", propertyReader.get("Android.deviceName"));
            dcap.setCapability("udid", propertyReader.get("Android.udid"));
            dcap.setCapability("platformVersion", propertyReader.get("Android.Version"));

            // Set app-specific capabilities for the package name and main activity to launch.
            dcap.setCapability("appium:appPackage", propertyReader.get("Android.appPackage"));
            dcap.setCapability("appium:appActivity", propertyReader.get("Android.appActivity"));

            // Specify the automation framework to use with Android.
            dcap.setCapability("appium:automationName", "uiAutomator2");

            // Define reset settings; fullReset and noReset are both set to false,
            // meaning the app state will be preserved across tests.
            dcap.setCapability("noReset", true);
            dcap.setCapability("appium:fullReset", false);

            // Sets adb execution timeout, which allows the server to wait longer for adb commands to complete.
            dcap.setCapability("adbExecTimeout", 50000);

            // Instantiate the AndroidDriver with specified capabilities and server URL.
            appiumDriver = new AndroidDriver(new URL(propertyReader.get("Appium.URL")), dcap);

            // Enforces XPath version compatibility, though this setting may not work on all devices.
            appiumDriver.setSetting("enforceXPath1", true);

            // Initialize common operations utility with the appiumDriver instance.
            commonOperations = new CommonOperations(appiumDriver);
        } else if (platformName.equalsIgnoreCase("iOS")) {
            // Placeholder for iOS configuration setup.
            System.out.println("Setup iOS App configs");
        }
    }

    @AfterClass
    // Terminates the Appium driver session after tests complete.
    public void endDriver() {
        appiumDriver.quit();
    }
}
