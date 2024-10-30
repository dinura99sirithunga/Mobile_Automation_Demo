package tests.mobileTest.loginScreen;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageElementsFactory.homeScreen.homeScreenElements;
import pageElementsFactory.formScreen.formScreenElements;
import pageElementsFactory.loginScreen.loginScreenElements;
import util.baseConfig;

public class loginScreenTest extends baseConfig {
    public homeScreenElements homeScreenElements;
    public loginScreenElements loginElements;
    SoftAssert softAssert;

    @Test(priority = 1, description = "Verify Landed On Home Screen")
    public void verifyLandedOnHomeScreen() {
        softAssert = new SoftAssert();
        test.get().info("Initializing home screen elements."); // Logging step
        homeScreenElements= new homeScreenElements(appiumDriver);
        softAssert.assertEquals(homeScreenElements.loginBtnTxt(),"Login","Bottom panel login test is not visible as expected.");
        homeScreenElements.tapOnLoginBtnIcon();
        softAssert.assertAll();
    }

}
