package tests.mobileTest.loginScreen;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageElementsFactory.homeScreenElements.homeScreenElements;
import pageElementsFactory.loginScreenElements.loginScreenElements;
import tests.baseConfig;
import util.CommonOperations;

import java.awt.datatransfer.ClipboardOwner;

public class loginScreenTest extends baseConfig {
    public homeScreenElements homeScreenElements;
    public loginScreenElements loginElements;
    SoftAssert softAssert;

    @Test(priority = 1, description = "Verify Landed On Home Screen")
    public void verifyLandedOnHomeScreen() {
        homeScreenElements= new homeScreenElements(androidDriver);
        homeScreenElements.clickSlWelcomeSkipBtn();
        Assert.assertTrue(homeScreenElements.getSlWelcomeImg(),"Hello Image is not present");
    }

    @Test(priority = 2,dependsOnMethods = {"verifyLandedOnHomeScreen"},description = "Verify the Login Screen Validation")
    public void verifyLoginValidation() {
        softAssert = new SoftAssert();
        loginElements = new loginScreenElements(androidDriver);
        loginElements.clickSlAirlinesLoginBtn();
        softAssert.assertEquals(loginElements.getLoginScreen(),"FlySmiLes Number\nPassword\nNot a member? ","Not Landed to Login Screen");
        for (int i=0;i<2;i++) {
            if (i==0) {
                loginElements.submitLoginCredentials("","");
                softAssert.assertEquals(loginElements.getErrorMsg("FlySmiLes Number Required"),"FlySmiLes Number Required", "FlySmiLes Number Validation Error Msg Did not Display");
                softAssert.assertEquals(loginElements.getErrorMsg("Password Required"),"Password Required", "Password Required Validation Error Msg Did not Display");
            } else if (i==1) {
                loginElements.submitLoginCredentials("3456","Terface90");
                softAssert.assertEquals(loginElements.getErrorMsg("Invalid FlySmiLes Number"),"Invalid FlySmiLes Number", "Invalid FlySmiLes Number error msg did not display");
            } else
            {
                new SkipException("Testcase is skipped");
            }
        }
        softAssert.assertAll();
    }
}
