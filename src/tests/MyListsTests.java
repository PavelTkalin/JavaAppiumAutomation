package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    @Test

    public void testSaveFirstArticleToMyList() {


        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleTitleToMyList("Learning programming");
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolder();

        MyListsPageObject.swipeByArticleToDelete(article_title);

    }


    @Test

    public void testSaveTwoArticlesToMyList() {


        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleTitleToMyList("Learning programming");
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("JavaScript");
        SearchPageObject.clickByArticle();
        ArticlePageObject ArticlePageObject2 = new ArticlePageObject(driver);
        ArticlePageObject2.waitForTitleElement();
        String article_title2 = ArticlePageObject2.getArticleTitle();
        ArticlePageObject2.addArticleTitleToMyExistingList();
        ArticlePageObject2.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();
        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName("Learning programming");
        MyListsPageObject.swipeByArticleToDelete(article_title);


        NavigationUI.clickMyLists();
        String expected_article_title = "JavaScript engine";
        String actual_article_title_javascript = article_title2;
        Assert.assertTrue(actual_article_title_javascript.contains(expected_article_title));

    }


}
