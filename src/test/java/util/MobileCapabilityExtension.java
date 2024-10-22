package util;

import io.appium.java_client.remote.MobileCapabilityType;

public interface MobileCapabilityExtension extends MobileCapabilityType {
    public static String appPackage = "appium:appPackage";
    public static String appActivity = "appium:appActivity";
    public static String automationName = "appium:automationName";
    public static String app = "app";
}
