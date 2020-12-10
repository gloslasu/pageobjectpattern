package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage{

    // we need create constructor to give 'static WebDriver driver;' from src/tests/java/tests/BaseTests to src/tests/java/tests/SearchTest (SearchResultPage searchResultPage = new SearchResultPage(driver);)
    public SearchResultPage(WebDriver driverIn){
        this.driver = driverIn; // driverIn is driver with comes from our method executed.
    }

    // we want to check if our searching product name is visible on search result page
    public boolean isProductWithNameVisible(String expectedProductName) {
       // findElements return List of elements so we must create variable to use found elements after in our code. cssSelector(String)
       List<WebElement> productsNames = driver.findElements(By.cssSelector(".product_list .product-name"));

       // Now we must create method to check every find element if it have 'expectedProductName'. We use foreach loop:
       // First we tell what is kind of element (WebElement), next give him a name (productsName), and in with collection are these productsName ? (productsNames)
       for (WebElement productsName: productsNames){
           System.out.println(productsName.getText()); // in console view we type what is find
           if (productsName.getText().toLowerCase().contains(expectedProductName.toLowerCase()));{
               return true; // if is return true
           }
       }
        return false; // when loop end and find nothing
    }

    public String getSearchSummary() {
        WebElement searchSummary = driver.findElement(By.cssSelector(".heading-counter"));
        return searchSummary.getText(); // we must return text we found
    }
}
