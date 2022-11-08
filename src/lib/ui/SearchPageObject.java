package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    public final static String
            SEARCH_INIT_ELEMENT = "org.wikipedia:id/fragment_feed_header",
            SEARCH_INPUT = "org.wikipedia:id/search_src_text",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text =' {substring}']",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_ELEMENT = "//*[@resource-id = 'org.wikipedia:id/search_results_list']//*[@resource-id = 'org.wikipedia:id/page_list_item_container']",
            SEARCH_EMPTY_RESULT_ELEMENT = "//*[contains(@text,'No results found')]";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);

    }

    /*TEMPLATES METHODS */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{substring}", substring);
    }

    /*TEMPLATES METHODS */
    public void initSearchInput() {
        this.waitForElementPresent(By.id(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element", 15);
        this.waitForElementAndClick(By.id(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element", 15);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "cannot find search Button", 15);

    }

    public void waitForCancelButtonToDisAppear() {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "cannot find search Button", 15);

    }

    public void clickCancelSearch() {

        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find and click cancel button", 5);

    }

    public void typeSearchLine(String line_search) {

        this.waitForElementAndSendKeys(By.id(SEARCH_INPUT), line_search, "Cannot type input", 15);

    }

    public void waitForSearchResult(String substring) {

        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result" + substring, 5);

    }


    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "error" + substring, 15);


    }


    public int getAmountOfFoundArticles() {

        this.waitForElementPresent(By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by request", 15);


        String search_resource_locator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView";

        this.waitForElementPresent(By.xpath(search_resource_locator),
                "Cannot find anything by request",
                15);

        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));


    }


    public void waitForEmptyResultsLabel() {

        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "", 15);


        String empty_result_label = "//*[contains(@text,'No results found')]";

        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT),
                "Cannot find empty results label by the request",
                15

        );

    }


    public void assertThereIsNoResultOfSearch() {

        this.assertElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT), "We supposed to find no results");

    }


}


