package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

// here we put selectors and methods common to all subpages of our test application.
// we do that because we can see in automationpractice.com that footer and headers are the same on all subpages
public class BasePage {

    WebDriver driver; // because our driver is here so every other class inherits this driver

    static final String BASE_URL = "http://automationpractice.com/";

    public void searchForProduct(String productName){
        // write searching keyword in search box and enter.
        driver.findElement(By.id("search_query_top")).sendKeys("dress"); // in search pool we type dress
        driver.findElement(By.id("search_query_top")).sendKeys(Keys.ENTER); // confirm searching phrase with enter

    }

}
