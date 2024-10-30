package pageElementsFactory.puzzelSolvingScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.CommonOperations;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PuzzleScreenElements {
    public CommonOperations commonOperations;
    AppiumDriver androidDriver;

    // Constructor to initialize driver and PageFactory elements
    public PuzzleScreenElements(AppiumDriver androidDriver) {
        this.androidDriver = androidDriver;
        commonOperations = new CommonOperations(androidDriver);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }
    
}
