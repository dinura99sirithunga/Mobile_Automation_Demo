package pageElementsFactory.loginScreenElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageElementsFactory.homeScreenElements.homeScreenElementsXpath;
import util.CommonOperations;

public class loginScreenElements {

    public CommonOperations commonOperations;
    AppiumDriver<MobileElement> androidDriver;

    public loginScreenElements(AppiumDriver<MobileElement> androidDriver) {
        this.androidDriver = androidDriver;
        commonOperations = new CommonOperations(androidDriver);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = loginScreenElementXpath.SL_AIRLINES_LOGIN_BTN)
    public WebElement slLoginBtn;
    @AndroidFindBy(accessibility = loginScreenElementXpath.SL_AIRLINES_LOGIN_SCREEN)
    public WebElement loginScreen;
    @AndroidFindBy(accessibility = loginScreenElementXpath.LOGIN_SCREEN_LOGIN_SBT)
    public WebElement loginSubmit;
    public void clickSlAirlinesLoginBtn() {
        commonOperations.waitForElementToBeClickable(androidDriver, slLoginBtn, 30);
        slLoginBtn.click();
    }
    public String getLoginScreen() {
        commonOperations.waitUntilElementVisible(androidDriver, loginScreen, 30);
        return loginScreen.getAttribute("content-desc");
    }
    public WebElement getUserNameAndPassword(int i) {
        WebElement userNamePassWord = androidDriver.findElement(By.xpath("//android.view.View[@content-desc='Forgot your password?']/preceding::android.widget.EditText[" + i +"]"));
        commonOperations.waitUntilElementVisible(androidDriver, userNamePassWord, 30);
        userNamePassWord.clear();
        return userNamePassWord;
    }
    public void submitLoginCredentials(String userName,String passWord) {
        this.getUserNameAndPassword(2).click();
        this.getUserNameAndPassword(2).sendKeys(userName);
        this.getUserNameAndPassword(1).click();
        this.getUserNameAndPassword(1).sendKeys(passWord);
        commonOperations.scrollDown();
        commonOperations.waitForElementToBeClickable(androidDriver, loginSubmit, 30);
        loginSubmit.click();
    }
    public String getErrorMsg(String contentDesc) {
        WebElement errorMsg = androidDriver.findElement(By.xpath("//android.view.View[@content-desc='" + contentDesc + "']"));
        commonOperations.waitUntilElementVisible(androidDriver, errorMsg, 30);
        return errorMsg.getAttribute("content-desc");
    }
}
