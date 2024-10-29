package pageElementsFactory.homeScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.CommonOperations;

public class homeScreenElements {
    public CommonOperations commonOperations;
    AppiumDriver androidDriver;

    public homeScreenElements(AppiumDriver androidDriver) {
        this.androidDriver = androidDriver;
        commonOperations = new CommonOperations(androidDriver);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(accessibility = "Login")
    public WebElement loginBtnBottomTab;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Login']/child::android.widget.TextView[2]")
    public WebElement loginBtnTxtBottomTab;

    public void tapOnLoginBtnIcon() {
        commonOperations.waitForElementToBeClickable(androidDriver, loginBtnBottomTab, 30);
        loginBtnBottomTab.click();
    }
    public String loginBtnTxt() {
        commonOperations.waitUntilElementVisible(androidDriver, loginBtnTxtBottomTab, 30);
        return loginBtnTxtBottomTab.getText();
    }

}
