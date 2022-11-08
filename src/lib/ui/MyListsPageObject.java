package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject {

    public static final String

            FOLDER_BY_NAME_TPL = "//*[@text =' {FOLDERNAME}']",
            ARTICLE_BY_TITLE = "//*[@text ='{TITLE}')]";

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);

    }

    public static String getSavedArticleXpathByTitle(String article_title) {
        return ARTICLE_BY_TITLE.replace("{FOLDERNAME}", article_title);

    }


    public static String getFolderXpathByName(String name_of_folder) {
        return FOLDER_BY_NAME_TPL.replace("{FOLDERNAME}", name_of_folder);

    }

    public void openFolderByName(String name_of_folder) {

        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(By.xpath(folder_name_xpath), "cannot find folder by name" + name_of_folder, 5);

    }


    public void waitForArticleTitleToAppearByTitle(String article_title) {

        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementPresent(By.xpath(article_xpath), "Cannot find saved article" + article_title, 15);

    }

    public void waitForArticleTitleToDissappearByTitle(String article_title) {

        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementAndClick(By.xpath(article_xpath), "Saved article still present with title" + article_title, 15);

    }


    public void swipeByArticleToDelete(String article_title) {

        this.waitForArticleTitleToAppearByTitle(article_title);

        String article_xpath = getFolderXpathByName(article_title);
        this.swipeElementToLeft(By.xpath(article_xpath), "Cannot swipe");
        this.waitForArticleTitleToDissappearByTitle(article_title);

    }


}
