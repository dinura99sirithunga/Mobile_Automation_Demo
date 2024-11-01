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

    @AndroidFindBy(accessibility = "Drag")
    public WebElement Drag;
    @AndroidFindBy(accessibility = "drag-l1")
    public WebElement Drag1;
    @AndroidFindBy(accessibility = "drop-l1")
    public WebElement Drop1;
    @AndroidFindBy(accessibility = "drag-l2")
    public WebElement Drag2;
    @AndroidFindBy(accessibility = "drop-l2")
    public WebElement Drop2;
    @AndroidFindBy(accessibility = "drag-l3")
    public WebElement Drag3;
    @AndroidFindBy(accessibility = "drop-l3")
    public WebElement Drop3;
    @AndroidFindBy(accessibility = "drag-r1")
    public WebElement Drag4;
    @AndroidFindBy(accessibility = "drop-r1")
    public WebElement Drop4;
    @AndroidFindBy(accessibility = "drag-r2")
    public WebElement Drag5;
    @AndroidFindBy(accessibility = "drop-r2")
    public WebElement Drop5;
    @AndroidFindBy(accessibility = "drag-r3")
    public WebElement Drag6;
    @AndroidFindBy(accessibility = "drop-r3")
    public WebElement Drop6;
    @AndroidFindBy(accessibility = "drag-c1")
    public WebElement Drag7;
    @AndroidFindBy(accessibility = "drop-c1")
    public WebElement Drop7;
    @AndroidFindBy(accessibility = "drag-c2")
    public WebElement Drag8;
    @AndroidFindBy(accessibility = "drop-c2")
    public WebElement Drop8;
    @AndroidFindBy(accessibility = "drag-c3")
    public WebElement Drag9;
    @AndroidFindBy(accessibility = "drop-c3")
    public WebElement Drop9;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Congratulations']")
    public WebElement congratsTxt;

    //String dragElementDesc, String dropElementDesc
    public void dragAndDrop() {
        List<Integer> numbers = new ArrayList<>();

        // Populate the list with numbers from 1 to 9
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        // Shuffle the list to randomize the order
        Collections.shuffle(numbers);
        for(int number : numbers) {
            WebElement dragElement;
            WebElement dropElement;
            switch (number) {
                case 1:
                    dragElement = Drag1;
                    dropElement = Drop1;
                    break;
                case 2:
                    dragElement = Drag2;
                    dropElement = Drop2;
                    break;
                case 3:
                    dragElement = Drag3;
                    dropElement = Drop3;
                    break;
                case 4:
                    dragElement = Drag4;
                    dropElement = Drop4;
                    break;
                case 5:
                    dragElement = Drag5;
                    dropElement = Drop5;
                    break;
                case 6:
                    dragElement = Drag6;
                    dropElement = Drop6;
                    break;
                case 7:
                    dragElement = Drag7;
                    dropElement = Drop7;
                    break;
                case 8:
                    dragElement = Drag8;
                    dropElement = Drop8;
                    break;
                case 9:
                    dragElement = Drag9;
                    dropElement = Drop9;
                    break;
                default:
                    continue;
            }

            TouchAction action = new TouchAction((PerformsTouchActions) androidDriver);

            action.longPress(ElementOption.element(dragElement))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(ElementOption.element(dropElement))
                    .release()
                    .perform();
        }
    }

    // Verify if puzzle is solved based on specific criteria or element visibility
    public boolean isPuzzleSolved() {
        commonOperations.waitUntilElementVisible(androidDriver,congratsTxt,10);
        return congratsTxt.isDisplayed();
    }

    public void tapOnDrag(){
        commonOperations.waitUntilElementVisible(androidDriver,Drag,10);
        Drag.click();
    }
}
