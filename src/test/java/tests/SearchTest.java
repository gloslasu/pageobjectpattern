package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.OtoMotoHomePage;
import pageobjects.SearchResultPage;

// extends mean that we load every elements from class BaseTests to class SearchTest
public class SearchTest extends BaseTests {


    @Test
    void shouldReturnCorrectProductListWhenPositiveSearchPhraseIsUsed() {
        // because our method from class HomePage are not static so we must create object
        OtoMotoHomePage otoMotoHomePage = new OtoMotoHomePage(driver, wait);
        otoMotoHomePage.navigateToOtoMotoMainPage(); // Open main Page.
        otoMotoHomePage.searchForProduct("finding key word in body of method"); // give searching keyword in search box
        //Thread.sleep(2000);

        // every open new page we need to create new object of this page
        SearchResultPage searchResultPage = new SearchResultPage(driver, wait); // here we have object from class SearchResultPage so now we can execute on this object some methods
        // adding assertion to check if search result is correct (shown find product names).
        Assertions.assertTrue(searchResultPage.isProductWithNameVisible("dress"));
        // Thread.sleep(8000);
        // assertion: ('7 results have been found.')
        Assertions.assertEquals("7 results have been found.", searchResultPage.getSearchSummary());

    }

}
