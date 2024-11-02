package tests.mobileTest.loginScreen;

import org.testng.annotations.BeforeMethod;
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
    // Setup method to initialize elements before each test
    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
        homeScreenElements = new homeScreenElements(appiumDriver);
        loginElements = new loginScreenElements(appiumDriver);
    }

    @Test(priority = 1, description = "Verify login function with valid login credentials ")
    public void verifyLandedOnHomeScreen() {
        softAssert = new SoftAssert();
        test.get().info("Initializing home screen elements."); // Logging step

        test.get().info("Verify home screen Login button is available");
        softAssert.assertEquals(homeScreenElements.loginBtnTxt(),"Login","Bottom panel login test is not visible as expected.");
        test.get().pass("Verify home screen Login button is available");

        test.get().info("Tap on home screen login button");
        homeScreenElements.tapOnLoginBtnIcon();
        test.get().pass("Successfully tapped on home screen login button");

        test.get().info("Verify Login screen elements");
        softAssert.assertEquals(loginElements.loginScreenHeadingTxt(),"Login / Sign up Form","Login screen heading is not visible as expected!");
        softAssert.assertTrue(loginElements.verifyLoginTabBtn(),"Login button tab is not available");
        softAssert.assertTrue(loginElements.verifySignUpTabBtn(),"Sign up button tab is not available");

        softAssert.assertEquals(loginElements.verifyLoginTabBtnTxt(),"Login","Login tab is not available");
        softAssert.assertEquals(loginElements.verifySignUpTabBtnTxt(),"Sign up","Sign up tab tab is not available");

        softAssert.assertTrue(loginElements.verifyEmailBoxIcon(),"Email icon is not available");
        softAssert.assertTrue(loginElements.verifyPasswordLockIcon(),"Password lock icon is not available");
        test.get().pass("Successfully login screen verified");

        test.get().info("Verify Login button");
        softAssert.assertEquals(loginElements.verifyLoginBtnTxt(),"LOGIN","Login button text is not visible as expected");
        test.get().pass("Login button successfully verified");

        test.get().info("Tap on login button without adding any data");
        loginElements.tapOnLoginBtn();
        test.get().pass("Successfully tapped on the login button");

        test.get().info("Verify error messages");
        softAssert.assertEquals(loginElements.emailErrorTxt(),"Please enter a valid email address","Email error is not visible as expected.");
        softAssert.assertEquals(loginElements.passwordErrorTxt(),"Please enter at least 8 characters","Password error is not visible as expected.");
        test.get().pass("Successfully verified");

        test.get().info("Set test data into text fields");
        loginElements.setEmailTxt("test12@gmail.com");
        loginElements.setPassword("test12@gmail.com");
        test.get().pass("Successfully added test data");

        test.get().info("Tap on login button after adding test data");
        loginElements.tapOnLoginBtn();
        test.get().pass("Successfully tapped on the login button");

        test.get().info("Verify Success pop up");
        softAssert.assertEquals(loginElements.verifySuccessAlertTitle(),"Success","Success alert heading is not visible as expected!");
        softAssert.assertEquals(loginElements.verifySuccessAlertMessage(),"You are logged in!","Login button tab is not available");
        test.get().pass("Successfully verified success pop up");

        test.get().info("Tap on 'Ok' button");
        loginElements.tapOnOkBtn();
        test.get().pass("Successfully tapped on the 'OK' button");

        softAssert.assertAll();
    }

}
