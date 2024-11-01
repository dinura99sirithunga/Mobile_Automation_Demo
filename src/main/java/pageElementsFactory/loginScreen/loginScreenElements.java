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

    @AndroidFindBy(accessibility = "button-sign-up-container")
    public WebElement signUpTabBtn;

    @AndroidFindBy(accessibility = "button-login-container")
    public WebElement loginTabBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-sign-up-container']//android.widget.TextView")
    public WebElement signUpTabBtnTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-login-container']//android.widget.TextView")
    public WebElement loginTabBtnTxt;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='input-email']/preceding-sibling::android.widget.TextView")
    public WebElement emailBoxIcon;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='input-password']/preceding-sibling::android.widget.TextView")
    public WebElement passwordLockIcon;

    @AndroidFindBy(accessibility = "input-email")
    public WebElement inputEmail;

    @AndroidFindBy(accessibility = "input-password")
    public WebElement inputPassword;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-LOGIN']/preceding-sibling::android.widget.TextView[1]")
    public WebElement descriptionTxt;

    @AndroidFindBy(accessibility = "button-LOGIN")
    public WebElement loginBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-LOGIN']/child::android.view.ViewGroup/android.widget.TextView")
    public WebElement loginBtnTxt;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    public WebElement successPopUpTxt;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    public WebElement successPopUpOkBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']")
    public WebElement successAlertTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please enter at least 8 characters']")
    public WebElement passwordError;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please enter a valid email address']")
    public WebElement emailError;

    public String loginScreenHeadingTxt() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginScreenHeading, 30);
        return loginScreenHeading.getText();
    }
    public void tapOnLoginTab() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginTabBtn, 30);
        loginTabBtn.click();
    }
    public boolean verifyLoginTabBtn() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginTabBtn, 30);
        return loginTabBtn.isDisplayed();
    }
    public void tapOnSignUpTab() {
        commonOperations.waitForElementToBeClickable(androidDriver, signUpTabBtn, 30);
        signUpTabBtn.click();
    }
    public boolean verifySignUpTabBtn() {
        commonOperations.waitForElementToBeClickable(androidDriver, signUpTabBtn, 30);
        return signUpTabBtn.isDisplayed();
    }
    public String verifySignUpTabBtnTxt() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginTabBtnTxt, 30);
        return signUpTabBtnTxt.getText();
    }
    public String verifyLoginTabBtnTxt() {
        commonOperations.waitForElementToBeClickable(androidDriver, signUpTabBtnTxt, 30);
        return loginTabBtnTxt.getText();
    }

    public boolean verifyEmailBoxIcon() {
        commonOperations.waitForElementToBeClickable(androidDriver, emailBoxIcon, 30);
        return emailBoxIcon.isDisplayed();
    }
    public boolean verifyPasswordLockIcon() {
        commonOperations.waitForElementToBeClickable(androidDriver, passwordLockIcon, 30);
        return passwordLockIcon.isDisplayed();
    }

    public void setEmailTxt(String email) {
        commonOperations.waitForElementToBeClickable(androidDriver, inputEmail, 30);
        inputEmail.sendKeys(email);
    }
    public void setPassword(String password) {
        commonOperations.waitForElementToBeClickable(androidDriver, inputPassword, 30);
        inputPassword.sendKeys(password);
    }
    public void tapOnLoginBtn() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginBtn, 30);
        loginBtn.click();
    }
    public String verifyLoginBtnTxt() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginBtnTxt, 30);
        return loginBtnTxt.getText();
    }
    public String verifySuccessAlertTitle() {
        commonOperations.waitForElementToBeClickable(androidDriver, successAlertTitle, 30);
        return successAlertTitle.getText();
    }
    public String verifySuccessAlertMessage() {
        commonOperations.waitForElementToBeClickable(androidDriver, successPopUpTxt, 30);
        return successPopUpTxt.getText();
    }
    public void tapOnOkBtn() {
        commonOperations.waitForElementToBeClickable(androidDriver, successPopUpOkBtn, 30);
        successPopUpOkBtn.click();
    }
    public String emailErrorTxt() {
        commonOperations.waitForElementToBeClickable(androidDriver, emailError, 30);
        return emailError.getText();
    }
    public String passwordErrorTxt() {
        commonOperations.waitForElementToBeClickable(androidDriver, passwordError, 30);
        return passwordError.getText();
    }




}
