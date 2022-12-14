package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import lib.Platform;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {


    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {

        this.driver = driver;

    }

    public void clickElementToTheRightUpCorner(String locator, String error_message) {
        WebElement element = this.waitForElementPresent(locator + "/..", error_message, 15);
        int right_x = element.getLocation().getX();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;
        int width = element.getSize().getWidth();

        int point_to_click_x = (right_x + width) - 3;
        int point_to_click_y = middle_y;

        TouchAction action = new TouchAction(driver);
        action.tap(point_to_click_x, point_to_click_y).perform();
    }

    protected void swipeUpQuick() {
        swipeUp(2000);

    }

    public void swipeUptToFindElement(String locator, String error_message, int max_swipes) {

        By by = getLocatorByString(locator);
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swiped > max_swipes) {
                waitForElementPresent(by.toString(), "Cannot find", 15);
                return;
            }

            swipeUp(2000);
            ++already_swiped;
        }
    }

    public void swipeUpTillElementAppear(String locator, String error_message, int max_swipes) {
        int already_swiped = 0;

        while (this.isElementLocatedOnTheScreen(locator)) {

            if (already_swiped > max_swipes) {
                Assert.assertTrue(error_message, this.isElementLocatedOnTheScreen(locator));
            }

            swipeUpQuick();
            ++already_swiped;
        }
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds) {

        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + " \n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds) {

        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;

    }


    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds) {

        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;

    }

    public boolean isElementLocatedOnTheScreen(String locator) {
        int element_location_by_y = this.waitForElementPresent(locator, "Cannot find element by locator", 1).getLocation().getY();
        int screen_size_by_y = driver.manage().window().getSize().getHeight();
        return element_location_by_y < screen_size_by_y;
    }

    public void swipeElementToLeft(String locator, String error_message) {

        WebElement element = waitForElementPresent(locator, error_message, 10);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);

        action.press(right_x, middle_y);
        action.waitAction(300);
        if (Platform.getInstance().isAndroid()) {

            action.moveTo(left_x, middle_y);
        } else {

            int offset_x = (-1 * element.getSize().getWidth());
            action.moveTo(offset_x, 0);
        }
        action.release();
        action.perform();


    }


    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds) {

        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + " \n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    public WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }


    public void assertElementHasText(String locator, String error_message, long timeoutInSeconds) {

        WebElement title_element = waitForElementPresent(locator, "Page not found", 5);
        String article_title = title_element.getText();

    }


    public int getAmountOfElements(String locator) {

        By by = getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    //   System.out.println("First test run");


    public void assertElementNotPresent(String locator, String error_message) {

        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements > 0) {
            String default_message = "An element" + locator + "supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);


        }


    }

    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeOutInSeconds) {


        WebElement element = waitForElementPresent(locator, attribute, timeOutInSeconds);
        return element.getAttribute(attribute);


    }


    public void assertElementIsPresenting(String locator, String error_message, long timeoutInSeconds) {
        By by = getLocatorByString(locator);
        boolean isTrue = driver.findElement(by).isDisplayed();
        Assert.assertTrue(isTrue);


    }

    public void swipeUp(int timeOfSwipe) {

        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);

        action
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release()
                .perform();
    }


    private By getLocatorByString(String locator_with_type) {

        String[] exploded_locator = locator_with_type.split(Pattern.quote("s"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];


        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type of locator.Locator" + locator_with_type);
        }

    }

}



