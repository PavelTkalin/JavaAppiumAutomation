package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "id:org.wikipedia:id/fragment_feed_header";
        SEARCH_INPUT = "id:org.wikipedia:id/search_src_text";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text =' {substring}']";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_BUTTON = "id:org.wikipedia:id/search_src_text";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id = 'org.wikipedia:id/search_results_list']//*[@resource-id = 'org.wikipedia:id/page_list_item_container']";
        SEARCH_MAIN_ARTICLE = "xpath://android.widget.FrameLayout[@content-desc='Explore']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[contains(@text,'No results found')]";
    }

    public AndroidSearchPageObject(AppiumDriver driver) {

        super(driver);
    }
}
