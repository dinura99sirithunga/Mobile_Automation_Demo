package pageElementsFactory.loginScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.CommonOperations;

public class loginScreenElements {

    public CommonOperations commonOperations;
    AppiumDriver androidDriver;

    public loginScreenElements(AppiumDriver androidDriver) {
        this.androidDriver = androidDriver;
        commonOperations = new CommonOperations(androidDriver);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "(//android.view.ViewGroup/child::android.widget.TextView)[1]")
    public WebElement loginScreenHeading;

    @AndroidFindBy(xpath = "button-sign-up-container")
    public WebElement signUpTabBtn;

    @AndroidFindBy(accessibility = "button-login-container")
    public WebElement loginTabBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-login-container']//android.widget.TextView")
    public WebElement signUpTabBtnTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-login-container']//android.widget.TextView")
    public WebElement loginTabBtnTxt;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='input-email']/preceding-sibling::android.widget.TextView")
    public WebElement emailBoxIcon;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='input-password']/preceding-sibling::android.widget.TextView")
    public WebElement passwordLockIcon;

    @AndroidFindBy(xpath = "input-email")
    public WebElement inputEmail;

    @AndroidFindBy(accessibility = "input-password")
    public WebElement inputPassword;

    @AndroidFindBy(accessibility = "//android.view.ViewGroup[@content-desc='button-LOGIN']/preceding-sibling::android.widget.TextView[1]")
    public WebElement descriptionTxt;

    @AndroidFindBy(accessibility = "//android.view.ViewGroup[@content-desc='button-LOGIN']/preceding-sibling::android.widget.TextView[1]")
    public WebElement loginBtn;

    public void loginScreenHeadingTxt() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginScreenHeading, 30);
        loginScreenHeading.getText();
    }
    public boolean tapOnLoginTab() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginTabBtn, 30);
        return loginTabBtn.isDisplayed();
    }
    public boolean verifyLoginTabBtn() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginTabBtn, 30);
        return loginTabBtn.isDisplayed();
    }
    public boolean verifySignUpTabBtn() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginTabBtn, 30);
        return signUpTabBtn.isDisplayed();
    }
    public String verifySignUpTabBtnTxt() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginTabBtn, 30);
        return loginTabBtnTxt.getText();
    }
    public String verifyLoginTabBtnTxt() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginTabBtn, 30);
        return signUpTabBtnTxt.getText();
    }



}
