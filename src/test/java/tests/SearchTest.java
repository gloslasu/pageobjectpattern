package tests;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

// extends mean that we load every elements from class BaseTests to class SearchTest
public class SearchTest extends BaseTests {


    @Test
    void shouldReturnCorrectProductListWhenPositiveSearchPhraseIsUsed() throws InterruptedException {


        // because our method from class HomePage are not static so we must create object
        HomePage homePage = new HomePage(driver);
        homePage.openPage(); // Open main Page.
        homePage.searchForProduct("blouse"); // give searching keyword in search box
        //Thread.sleep(2000);

        // every open new page we need to create new object of this page
        SearchResultPage searchResultPage = new SearchResultPage(driver); // here we have object from class SearchResultPage so now we can execute on this object some methods
        // adding assertion to check if search result is correct (shown find product names).
        Assertions.assertTrue(searchResultPage.isProductWithNameVisible("dress"));
        //Thread.sleep(2000);
        // assertion: ('7 results have been found.')
        Assertions.assertEquals("7 results have been found.", searchResultPage.getSearchSummary());

    }

}
