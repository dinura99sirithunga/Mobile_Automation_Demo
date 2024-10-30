package pageElementsFactory.loginScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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

}
