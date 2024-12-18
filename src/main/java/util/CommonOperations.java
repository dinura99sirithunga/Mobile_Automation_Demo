package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Collections;

import static java.time.Duration.ofSeconds;

public class CommonOperations {
    private final AppiumDriver androidDriver;

    int sleepTime;

    public CommonOperations(AppiumDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public boolean isPageLoading(AppiumDriver androidDriver) {
        JavascriptExecutor js = (JavascriptExecutor) androidDriver;
        String strExec = "return document.readyState!=\'complete\';";
        return ((Boolean) js.executeScript(strExec, new Object[0])).booleanValue();
    }

    public void waitUntilPageLoaded(AppiumDriver androidDriver) {
        while (this.isPageLoading(androidDriver)) {
            try {
                Thread.sleep((long) this.sleepTime);
            } catch (InterruptedException var3) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void waitForSpecificTime(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementVisible(AppiumDriver androidDriver, WebElement element, int delay) {
        try {
            WebDriverWait wait = new WebDriverWait(androidDriver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Web element not visible within given time" + element + " Time " + delay);
        }
    }

    public void waitForElementToBeClickable(AppiumDriver androidDriver, WebElement element, int delay) {
    try {
        WebDriverWait wait = new WebDriverWait(androidDriver,Duration.ofSeconds(delay));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    } catch (NoSuchElementException e) {
        throw new RuntimeException("Web element not visible within given time" + element + " Time " + delay);
    }
    }


    public void scrollDown() {
        Dimension size = androidDriver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.25);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        androidDriver.perform(Collections.singletonList(sequence));

    }
    public void scrollDown_Until(WebElement element) {
        do {
        Dimension size = androidDriver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.25);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            androidDriver.perform(Collections.singletonList(sequence));
        }while (element.isDisplayed());

    }
    public void selectFileImageFromLocal(String filePath) {
        StringSelection stringSelection = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    private void dragAndDrop(String dragElementDesc, WebElement dropElementDesc) {
        // Locate the drag element (puzzle piece) by its content-desc
        WebElement dragElement = androidDriver.findElement(By.ById.id(dragElementDesc));

        // Locate the drop element (target location) by its content-desc
        WebElement dropElement = androidDriver.findElement(By.ById.id(dragElementDesc));

        // Create a new TouchAction for drag and drop
        TouchAction action = new TouchAction((PerformsTouchActions) androidDriver);
        action.longPress(ElementOption.element(dragElement))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(ElementOption.element(dropElement))
                .release()
                .perform();
    }
}
