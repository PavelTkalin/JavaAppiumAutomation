import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;

public class FirstTest {

private AppiumDriver driver;

@Before

    public void setUp() throws Exception

{

    DesiredCapabilities capabilities = new DesiredCapabilities();

    capabilities.setCapability("platformName","Android");
    capabilities.setCapability("deviceName","AndroidTestDevice");
    capabilities.setCapability("platformVersion","8.0");
    capabilities.setCapability("automationName","Appium");
    capabilities.setCapability("appPackage","org.wikipedia");
    capabilities.setCapability("appActivity",".main.MainActivity");
    capabilities.setCapability("app","C:\\Pavel_data\\STUDY\\JavaAppiumAutomation\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");


    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

}

@After

   public void tearDown ()
{driver.quit();
}


@Test
    public void assertElementHasText()

    {

        waitForElementPresent(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find object-oriented programming language searching by Java", 15);
        waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);
        waitForElementPresent(By.id("org.wikipedia:id/search_src_text"), "Cannot find Search field", 15);
        assertElementHasText(By.id("org.wikipedia:id/search_src_text"), "Search…", "Cannot find 'Search…'", 15);

    }


/*

    @Test


public void cancelTestSearch()

{

waitForElementPresent(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find object-oriented programming language searching by Java", 15);
waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);
waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"), "Java", "Cannot find Java", 5);
waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text ='Java']"),"Cannot find object-oriented programming language searching by Java" , 15);
waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text ='JavaScript']"),"Cannot find object-oriented programming language searching by JavaScript" , 15);
waitForElementAndClear(By.id("org.wikipedia:id/search_src_text"), "Cannot clear", 5);
waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/fragment_main_nav_tab_layout']//*[@text ='Explore']"),"Search is not cleared" , 15);
}


    @Test


    public void verifyTestSearch()

    {

        waitForElementPresent(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find object-oriented programming language searching by Java", 15);
        waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);
        waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"), "Java", "Cannot find Java", 5);
        waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text ='Java']"),"Cannot find object-oriented programming language searching by Java" , 15);
        waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text ='JavaScript']"),"Cannot find object-oriented programming language searching by JavaScript" , 15);
        WebElement java = waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text ='Java']"),"Cannot find object-oriented programming language searching by Java" , 15);
        WebElement javaScript = waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text ='JavaScript']"),"Cannot find object-oriented programming language searching by JavaScript" , 15);
        String article_title_java = java.getText();
        String article_title_javascript = javaScript.getText();
        Assert.assertEquals("","Java",article_title_java);
        Assert.assertEquals("","JavaScript",article_title_javascript);
    }

*/

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)

    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + " \n" );
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }




    private WebElement waitForElementAndClick (By by, String error_message, long timeoutInSeconds)

    {

        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;

    }



    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)

    {

        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;

    }



    private Boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)


    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message);
        return  wait.until(ExpectedConditions.invisibilityOfElementLocated(by)

        );

    }
        private WebElement waitForElementAndClear (By by, String error_message, long timeoutInSeconds)

        {
WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
element.clear();
return element;
    }


    private WebElement assertElementHasText (By by, String text, String error_message, long timeoutInSeconds)

    {

        WebElement title_element = waitForElementPresent(by, "Page not found", 5);
        String article_title = title_element.getText();
        Assert.assertEquals("Text is not present",text,article_title);
        return title_element;
    }


    //   System.out.println("First test run");

}



