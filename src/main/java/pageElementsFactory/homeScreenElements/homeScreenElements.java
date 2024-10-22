package pageElementsFactory.homeScreenElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.CommonOperations;

public class homeScreenElements {
    public CommonOperations commonOperations;
    AppiumDriver<MobileElement> androidDriver;

    public homeScreenElements(AppiumDriver<MobileElement> androidDriver) {
        this.androidDriver = androidDriver;
        commonOperations = new CommonOperations(androidDriver);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = homeScreenElementsXpath.SL_AIRLINES_SKIP_BTN)
    public WebElement slWelcomeScrnSkipBtn;
    @AndroidFindBy(xpath = homeScreenElementsXpath.HOME_SCREEN_HEADER_LOGO)
    public WebElement slAirlinesLogo;
    @AndroidFindBy(accessibility = homeScreenElementsXpath.WELCOME_IMAGE)
    public WebElement slWelcomeImg;
    @AndroidFindBy(id = homeScreenElementsXpath.SPLASH_SCREEN)
    public WebElement splashScreen;

    public void clickSlWelcomeSkipBtn() {
        commonOperations.waitForElementToBeClickable(androidDriver, slWelcomeScrnSkipBtn, 30);
        slWelcomeScrnSkipBtn.click();
    }
    public boolean getHomeScreenSlLogo() {
        commonOperations.waitUntilElementVisible(androidDriver, slAirlinesLogo, 30);
        return slAirlinesLogo.isDisplayed();
    }
    public boolean getSlWelcomeImg() {
        commonOperations.waitUntilElementVisible(androidDriver, slWelcomeImg, 30);
        return slWelcomeImg.isDisplayed();
    }
    public boolean getHomeScreenTabs(String tabName, int i) {
        WebElement tab = androidDriver.findElement(By.xpath("//android.widget.ImageView[@content-desc='" + tabName + "\n" + "Tab " + i +" of 5']"));
        commonOperations.waitUntilElementVisible(androidDriver, tab, 30);
        return tab.isDisplayed();
    }

    public void clickOnTab(String tabName, int i) {
        WebElement tab = androidDriver.findElement(By.xpath("//android.widget.ImageView[@content-desc='" + tabName + "\n" + "Tab " + i +" of 5']"));
        commonOperations.waitUntilElementVisible(androidDriver, tab, 30);
        tab.click();
    }

    public boolean verifyTabState(String tabName, int i) {
        WebElement tab = androidDriver.findElement(By.xpath("//android.widget.ImageView[@content-desc='" + tabName + "\n" + "Tab " + i +" of 5']"));
        commonOperations.waitUntilElementVisible(androidDriver, tab, 30);
        return  tab.isSelected();
    }

    public boolean getSplashScreen() {
        commonOperations.waitUntilElementVisible(androidDriver, splashScreen, 30);
        return splashScreen.isDisplayed();
    }
}
