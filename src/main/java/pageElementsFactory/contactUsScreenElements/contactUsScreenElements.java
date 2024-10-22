package pageElementsFactory.contactUsScreenElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.CommonOperations;

public class contactUsScreenElements {

    public CommonOperations commonOperations;
    AppiumDriver<MobileElement> androidDriver;

    public contactUsScreenElements(AppiumDriver<MobileElement> androidDriver) {
        this.androidDriver = androidDriver;
        commonOperations = new CommonOperations(androidDriver);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy (xpath = contactUsScreenElementXpath.CONTACTUS_TILE)
    public WebElement contactUsTile;
    @AndroidFindBy (accessibility = contactUsScreenElementXpath.CONTACTUS_HEADING)
    public WebElement contactUsHeading;
    @AndroidFindBy (xpath = contactUsScreenElementXpath.BACK_ARROW)
    public WebElement backArrow;
    @AndroidFindBy (xpath = contactUsScreenElementXpath.SL_AIRLINE_LOGO)
    public WebElement slAirlineLogo;
    @AndroidFindBy (xpath = contactUsScreenElementXpath.CONTACTUS_IMAGE)
    public WebElement contactUsImage;
    @AndroidFindBy (xpath = contactUsScreenElementXpath.HEADING_TEXT)
    public WebElement headingText;
    @AndroidFindBy (xpath = contactUsScreenElementXpath.SELECT_COUNTRY_DROPDOWN)
    public WebElement selectCountryDropDown;
    @AndroidFindBy (xpath = contactUsScreenElementXpath.SELECT_SRI_LANKA)
    public WebElement selectSriLanka_DropDown;

    public void clickOnContactUsTile() {
        commonOperations.waitForElementToBeClickable(androidDriver, contactUsTile, 30);
        contactUsTile.click();
    }
    public boolean verifyBackArrow() {
        commonOperations.waitForElementToBeClickable(androidDriver, backArrow, 30);
        return backArrow.isDisplayed();
    }
    public boolean verifyContactUsScreenHeading() {
        commonOperations.waitForElementToBeClickable(androidDriver, contactUsHeading, 30);
        return contactUsHeading.isDisplayed();
    }
    public boolean verifyAirlineLogo() {
        commonOperations.waitForElementToBeClickable(androidDriver, slAirlineLogo, 30);
        return slAirlineLogo.isDisplayed();
    }
    public boolean verifyScreenImage() {
        commonOperations.waitForElementToBeClickable(androidDriver, contactUsImage, 30);
        return contactUsImage.isDisplayed();
    }
    public String verifyHeadingTxt() {
        commonOperations.waitForElementToBeClickable(androidDriver, headingText, 30);
        return headingText.getText();
    }
    public boolean selectCountryIsDisplayed() {
        commonOperations.waitForElementToBeClickable(androidDriver, selectCountryDropDown, 30);
        return selectCountryDropDown.isDisplayed();
    }


}
