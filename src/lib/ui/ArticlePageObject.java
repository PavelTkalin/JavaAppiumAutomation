package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String

            TITLE = "org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "//*[@text = 'View page in browser']",
            OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[contains(@text,'Add to reading list')]",
            ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",

    ADD_TO_MY_EXISTING_LIST_OVERLAY = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]",
            MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";

    public ArticlePageObject(AppiumDriver driver) {

        super(driver);

    }

    public WebElement waitForTitleElement() {

        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title on page", 15);

    }

    public String getArticleTitle() {

        WebElement title_element = waitForTitleElement();
        return title_element.getText();

    }

    public void swipeToFooter() {

        this.swipeUptToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of article",
                100);

    }

    public void addArticleTitleToMyList(String name_of_folder) {

        this.waitForElementAndClick(By.xpath(OPTIONS_BUTTON), "cannot open", 5);
        this.waitForElementAndClick(By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON), "Cannot find option to add article to reading list", 15);
        this.waitForElementAndClick(By.id(ADD_TO_MY_LIST_OVERLAY), "Cannot got it tip overlay", 15);
        this.waitForElementAndClear(By.id(MY_LIST_NAME_INPUT), "Cannot find input to set name on articles folder", 15);
        this.waitForElementAndSendKeys(By.id(MY_LIST_NAME_INPUT), name_of_folder, "Cannot input article folder", 16);
        this.waitForElementAndClick(By.xpath(MY_LIST_OK_BUTTON), "Cannot find input to set name on articles folder", 15);

    }


    public void addArticleTitleToMyExistingList() {

        this.waitForElementAndClick(By.xpath(OPTIONS_BUTTON), "cannot open", 5);
        this.waitForElementAndClick(By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON), "Cannot find option to add article to reading list", 15);
        this.waitForElementAndClick(By.id(ADD_TO_MY_LIST_OVERLAY), "Cannot got it tip overlay", 15);
        this.waitForElementAndClick(By.id(ADD_TO_MY_EXISTING_LIST_OVERLAY), "Cannot got it tip overlay", 15);
        this.waitForElementAndClick(By.xpath(MY_LIST_OK_BUTTON), "Cannot find input to set name on articles folder", 15);

    }


    public void closeArticle() {

        this.waitForElementAndClick(By.xpath(CLOSE_ARTICLE_BUTTON), "Cannot close article", 5);

    }
}
