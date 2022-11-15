package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class ArticleTests extends CoreTestCase {


    @Test

    public void testCompareArticleTitle() {


        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        assertEquals("We see unexpected title", "Java (programming language)", article_title);

    }


    @Test
    public void testAssertElementHasText() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();
        SearchPageObject.assertElementHasText(ArticlePageObject.TITLE, "Cannot find element", 15);

    }


    @Test

    public void testAssertElementPresent() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();
        SearchPageObject.assertElementIsPresenting(ArticlePageObject.TITLE, "Cannot find element", 15);

    }

}
