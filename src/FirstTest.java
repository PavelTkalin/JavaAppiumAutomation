import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class FirstTest {

    private AppiumDriver driver;

    @Before

    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Pavel_data\\STUDY\\JavaAppiumAutomation\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After

    public void tearDown() {
        driver.quit();
    }

    /*
   @Test
       public void assertElementHasText()

       {

           waitForElementPresent(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find object-oriented programming language searching by Java", 15);
           waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);
           waitForElementPresent(By.id("org.wikipedia:id/search_src_text"), "Cannot find Search field", 15);
           assertElementHasText(By.id("org.wikipedia:id/search_src_text"), "Search…", "Cannot find 'Search…'", 15);

       }





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


       public void verifyTestSearch() {

           waitForElementPresent(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find object-oriented programming language searching by Java", 15);
           waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);
           waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"), "Java", "Cannot find Java", 5);
           waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text ='Java']"), "Cannot find object-oriented programming language searching by Java", 15);
           waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text ='JavaScript']"), "Cannot find object-oriented programming language searching by JavaScript", 15);
           WebElement java = waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text ='Java']"), "Cannot find object-oriented programming language searching by Java", 15);
           WebElement javaScript = waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text ='JavaScript']"), "Cannot find object-oriented programming language searching by JavaScript", 15);
           String expected_article_text = "Java";
           String actual_article_text_java = java.getText();
           String actual_article_text_javascript = javaScript.getText();
           Assert.assertTrue(actual_article_text_java.contains(expected_article_text));
           Assert.assertTrue(actual_article_text_javascript.contains(expected_article_text));

       }


       @Test
       public void testSwipeArticle() {


           waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);
           waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"), "Appium", "Cannot find Appium", 5);
           waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "", 15);
           waitForElementPresent(By.id("org.wikipedia:id/page_contents_container"), "No page found", 15);
           swipeUptToFindElement(By.xpath("//*[contains(@text,'View page in browser')]"), "Test error message", 20);


       }


       protected void swipeUp(int timeOfSwipe) {

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


       @Test

       public void saveFirstArticleToMyList() {


           waitForElementPresent(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find object-oriented programming language searching by Java", 15);
           waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);
           waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"), "Java", "Cannot find Java", 5);
           waitForElementPresent(By.id("org.wikipedia:id/fragment_main_nav_tab_layout"), "No page found", 15);
           waitForElementAndClick(By.id("org.wikipedia:id/fragment_main_nav_tab_layout"), "No page found", 15);
           waitForElementAndClick(By.xpath("//android.widget.ImageView[@content-desc='More options']"), "cannot open", 5);
           waitForElementAndClick(By.xpath("//*[contains(@text,'Add to reading list')]"), "Cannot find option to add article to reading list", 15);
           waitForElementAndClick(By.id("org.wikipedia:id/onboarding_button"), "Cannot got it tip overlay", 15);
           waitForElementAndClear(By.id("org.wikipedia:id/text_input"), "Cannot find input to set name on articles folder", 15);

           String name_of_folder = "Learning programming";

           waitForElementAndSendKeys(By.id("org.wikipedia:id/text_input"), name_of_folder, "Cannot input article folder", 16);
           waitForElementAndClear(By.xpath("//*[contains(@text,'OK')]"), "Cannot find input to set name on articles folder", 15);

           waitForElementAndClick(By.xpath("//*[contains(@text,'OK')]"), "cannot find list", 16);
           waitForElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"), "Cannot close article, cannot find X", 16);
           waitForElementAndClick(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"), "cannot find list", 16);
           waitForElementAndClick(By.xpath("//*[contains(@text,'Learning programming')]"), "cannot find list", 16);
           waitForElementPresent(By.xpath("//*[contains(@text,'Java (programming language)')]"), "cannot find list", 16);
           swipeElementToLeft(By.xpath("//*[contains(@text,'Java (programming language)')]"), "Cannot swipe");
           waitForElementPresent(By.xpath("//*[contains(@text,'Java (programming language)')]"), "Element is present on the page", 16);


       }


       @Test

       public void amountOfNotEmptySearch() {
           waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);

           String search_line = "Linking park discography";

           waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
                   search_line,
                   "Cannot find Java",
                   5);

           String search_resource_locator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView";

           waitForElementPresent(By.xpath(search_resource_locator),
                   "Cannot find anything by request" + search_line,
                   15);


           int amount_of_search_results = getAmountOfElements(
                   By.xpath(search_resource_locator));


           Assert.assertTrue(
                   "We found too few results",
                   amount_of_search_results > 0);
       }


       @Test

       public void testOfEmplyAmountSearch() {
           waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);

           String search_line = "zxcxdsfsdf";

           waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
                   search_line,
                   "Cannot find Java",
                   5);

           String search_result_locator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView";

           String empty_result_label = "//*[contains(@text,'No results found')]";

           waitForElementPresent(By.xpath(empty_result_label),
                   "Cannot find empty results label by the request" + search_line,
                   15

           );

           assertElementNotPresent(By.xpath(search_result_locator),
                   "We found some results by request" + search_line);
       }

       @Test

       public void changeScreenOrientationOnSearchResults() {

           waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);

           String search_line = "Java";
           waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"), search_line, "Cannot find Java", 5);


           waitForElementAndClick(By.xpath("//*[contains(@text,'Object-oriented programming language')]"), "No page found", 15);
           waitForElementPresent(By.id("org.wikipedia:id/view_page_title_text"), "cannot find element by id", 15);

           String title_before_rotation = waitForElementAndGetAttribute(
                   By.id("org.wikipedia:id/view_page_title_text"),
                   "text",
                   "Cannot find title of article",
                   15);

           driver.rotate(ScreenOrientation.LANDSCAPE);
           String title_after_rotation = waitForElementAndGetAttribute(By.id("org.wikipedia:id/fragment_main_nav_tab_layout"),
                   "text",
                   "Cannot find title of article",
                   15);

           Assert.assertEquals("Article title have been changed after screen rotation", title_before_rotation, title_after_rotation);

           driver.rotate(ScreenOrientation.PORTRAIT);

           String title_after_second_rotation = waitForElementAndGetAttribute(By.id("org.wikipedia:id/view_page_title_text"),
                   "text",
                   "Cannot find title of article",
                   15);

           Assert.assertEquals("Article title have been changed after screen rotation", title_before_rotation, title_after_rotation);

           Assert.assertEquals("Article title have been changed after screen rotation", title_before_rotation, title_after_second_rotation);
       }


       @Test

       public void testSearchArticleBackground() {
           waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Cannot find object-oriented programming language searching by Java", 15);
           waitForElementAndClick(By.xpath("//*[contains(@text,'Search…')]"), "Cannot find X to cancel search", 15);
           waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"), "Java", "Cannot find Java", 5);
           waitForElementPresent(By.id("org.wikipedia:id/fragment_main_nav_tab_layout"), "No page found", 15);
           driver.runAppInBackground(2);
           waitForElementPresent(By.id("org.wikipedia:id/fragment_main_nav_tab_layout"), "Cannot find article after returning from backgroundd", 15);

       }


    @Test

    public void testAssertElementPresent() {

        waitForElementPresent(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find object-oriented programming language searching by Java", 15);
        waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);
        waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"), "JavaScript engine", "Cannot find Java", 5);
        waitForElementPresent(By.xpath("//*[contains(@text,'JavaScript engine')]"), "No page found", 15);
        waitForElementAndClick(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"), "No page found", 15);
        waitForElementPresent(By.id("org.wikipedia:id/view_page_title_text"), "No page found", 15);
        isElementPresent(By.id("org.wikipedia:id/view_page_title_text"));
    }
   */

    @Test

    public void saveTwoArticlesToMyList() {


        waitForElementPresent(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find object-oriented programming language searching by Java", 15);
        waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);
        waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"), "Java", "Cannot find Java", 5);
        waitForElementPresent(By.id("org.wikipedia:id/fragment_main_nav_tab_layout"), "No page found", 15);
        waitForElementAndClick(By.id("org.wikipedia:id/fragment_main_nav_tab_layout"), "No page found", 15);
        waitForElementAndClick(By.xpath("//android.widget.ImageView[@content-desc='More options']"), "cannot open", 5);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Add to reading list')]"), "Cannot find option to add article to reading list", 15);
        waitForElementAndClick(By.id("org.wikipedia:id/onboarding_button"), "Cannot got it tip overlay", 15);
        waitForElementAndClear(By.id("org.wikipedia:id/text_input"), "Cannot find input to set name on articles folder", 15);
        String name_of_folder = "Learning programming";
        waitForElementAndSendKeys(By.id("org.wikipedia:id/text_input"), name_of_folder, "Cannot input article folder", 16);
        waitForElementAndClear(By.xpath("//*[contains(@text,'OK')]"), "Cannot find input to set name on articles folder", 15);
        waitForElementAndClick(By.xpath("//*[contains(@text,'OK')]"), "cannot find list", 16);
        waitForElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"), "Cannot close article, cannot find X", 16);


        waitForElementPresent(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find object-oriented programming language searching by Java", 15);
        waitForElementAndClick(By.id("org.wikipedia:id/fragment_feed_header"), "Cannot find X to cancel search", 15);
        waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"), "Javascript", "Cannot find Javascipt", 5);
        waitForElementPresent(By.id("org.wikipedia:id/fragment_main_nav_tab_layout"), "No page found", 15);
        waitForElementAndClick(By.id("org.wikipedia:id/fragment_main_nav_tab_layout"), "No page found", 15);
        waitForElementAndClick(By.xpath("//android.widget.ImageView[@content-desc='More options']"), "cannot open", 5);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Add to reading list')]"), "Cannot find option to add article to reading list", 15);
        waitForElementAndClick(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]"), "Cannot find option to add article to reading list", 15);
        waitForElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"), "Cannot close article, cannot find X", 16);

        waitForElementAndClick(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"), "cannot find list", 16);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Learning programming')]"), "cannot find list", 16);
        waitForElementPresent(By.xpath("//*[contains(@text,'Java (programming language)')]"), "cannot find list", 16);
        swipeElementToLeft(By.xpath("//*[contains(@text,'Java (programming language)')]"), "Cannot swipe");

        waitForElementAndClick(By.xpath("//*[contains(@text,'JavaScript engine')]"), "cannot find list", 16);
        WebElement javaScript = waitForElementPresent(By.id("org.wikipedia:id/view_page_title_text"), "Cannot find object-oriented programming language searching by JavaScript", 15);
        String expected_article_title = "JavaScript engine";
        String actual_article_title_javascript = javaScript.getText();
        Assert.assertTrue(actual_article_title_javascript.contains(expected_article_title));
    }

    protected void swipeUpQuick() {
        swipeUp(2000);

    }

    protected void swipeUptToFindElement(By by, String error_message, int max_swipes) {


        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swiped > max_swipes) {
                waitForElementPresent(by, "Cannot find", 15);
                return;
            }

            swipeUp(2000);
            ++already_swiped;
        }
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + " \n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {

        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;

    }


    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {

        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;

    }

    protected void swipeElementToLeft(By by, String error_message) {

        WebElement element = waitForElementPresent(by, error_message, 10);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(300)
                .moveTo(left_x, middle_y)
                .release()
                .perform();


    }


    private Boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by)

        );

    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }


    private WebElement assertElementHasText(By by, String text, String error_message, long timeoutInSeconds) {

        WebElement title_element = waitForElementPresent(by, "Page not found", 5);
        String article_title = title_element.getText();
        Assert.assertEquals("Text is not present", text, article_title);
        return title_element;
    }


    private int getAmountOfElements(By by) {

        List elements = driver.findElements(by);
        return elements.size();
    }

    //   System.out.println("First test run");


    private void assertElementNotPresent(By by, String error_message) {

        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 0) {
            String default_message = "An element" + by.toString() + "supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);


        }


    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeOutInSeconds) {


        WebElement element = waitForElementPresent(by, attribute, timeOutInSeconds);
        return element.getAttribute(attribute);


    }


    public boolean isElementPresent(By by) {


        try {


            waitForElementPresent(by, "", 15);
            driver.getTitle();

            return true;


        } catch (NoSuchElementException e) {


            return false;


        }

    }


}
