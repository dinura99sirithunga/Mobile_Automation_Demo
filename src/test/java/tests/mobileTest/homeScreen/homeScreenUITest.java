package tests.mobileTest.homeScreen;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageElementsFactory.homeScreenElements.homeScreenElements;
import tests.baseConfig;

public class homeScreenUITest extends baseConfig {

    public homeScreenElements homeScreenElements;
    SoftAssert softAssert;

    @Test(priority = 1, description = "Verify Home Screen UI Elements")
    public void verifyHomeScreenUIElements() {
        softAssert = new SoftAssert();
        homeScreenElements= new homeScreenElements(androidDriver);
        homeScreenElements.clickSlWelcomeSkipBtn();
        softAssert.assertTrue(homeScreenElements.getHomeScreenSlLogo(),"Srilankan Airlines Logo Is not present");
        softAssert.assertTrue(homeScreenElements.getSlWelcomeImg(),"Hello Image is not present");
        softAssert.assertTrue(homeScreenElements.getHomeScreenTabs("Home",1),"Home Tab is not present");
        softAssert.assertTrue(homeScreenElements.getHomeScreenTabs("Book",2),"Book Tab is not present");
        softAssert.assertTrue(homeScreenElements.getHomeScreenTabs("My Trips",3),"My Trips Tab is not present");
        softAssert.assertTrue(homeScreenElements.getHomeScreenTabs("FlySmiLes",4),"FlySmiLes Tab is not present");
        softAssert.assertTrue(homeScreenElements.getHomeScreenTabs("More",5),"More Tab is not present");
        softAssert.assertAll();
    }
}
