package tests.mobileTest.contactUsScreen;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageElementsFactory.homeScreenElements.homeScreenElements;
import pageElementsFactory.contactUsScreenElements.contactUsScreenElements;
import tests.baseConfig;

public class contactUsScreenUITest extends baseConfig {

    public homeScreenElements homeScreenElements;
    public contactUsScreenElements contactusScreenElements;
    SoftAssert softAssert;

    @Test(priority = 1, description = "Verify More tab is selected or not")
    public void verifyMoreButtonSelectedOrNot() {
        softAssert = new SoftAssert();
        homeScreenElements= new homeScreenElements(androidDriver);

        //Step 2 : Assert that the splash screen is displayed upon app launch.
        softAssert.assertTrue(homeScreenElements.getSplashScreen() , "Splash Screen is not present");
        homeScreenElements.clickSlWelcomeSkipBtn();

        //Step 3 : Assert that the home screen SL Airline logo is visible in main Screen.
        softAssert.assertTrue(homeScreenElements.getHomeScreenSlLogo(),"Sri Lankan Airlines Logo is not present");

        // Step 4 : Click on ‘More’ tab and Assert that the ‘More’ tab is in selected state.
        homeScreenElements.clickOnTab("More",5);
        softAssert.assertTrue(homeScreenElements.verifyTabState("More",5) , "More tab is not in selected state");
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Verify Contact Us Screen UI Elements" , dependsOnMethods = "verifyMoreButtonSelectedOrNot")
    public void verifyContactUsUIElements() {
        softAssert = new SoftAssert();
        contactusScreenElements = new contactUsScreenElements(androidDriver);

        //Step 5 : Click on ‘Contact Us’ button and navigate to Contact Us screen. | Verify UI elements
        contactusScreenElements.clickOnContactUsTile();
        softAssert.assertTrue(contactusScreenElements.verifyBackArrow() , "Back Arrow is not visible in the Contact Us Screen");
        softAssert.assertTrue(contactusScreenElements.verifyContactUsScreenHeading() , "Contact Us heading is not visible in the screen");
        softAssert.assertTrue(contactusScreenElements.verifyAirlineLogo() , "Airline Logo is not visible in the screen");
        softAssert.assertTrue(contactusScreenElements.verifyScreenImage() , "Contact Us screen image is not visible in the screen");

        // Step 6 : Assert that the contact details are correct.
        softAssert.assertEquals(contactusScreenElements.verifyHeadingTxt() , "24 Hour Contact Center (Colombo)" , "Heading text is not visible as expected");

        //Step 7 : Scroll down and select country as ‘Sri Lanka’.
        commonOperations.scrollDown();
        softAssert.assertTrue(contactusScreenElements.selectCountryIsDisplayed(),"The Select country list is not present");

        //Step 8 : To Do Step Scroll up and click on the back button and navigate to the ‘More’ screen.
        softAssert.assertAll();
    }
}
