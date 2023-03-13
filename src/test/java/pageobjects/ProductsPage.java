package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage{

    @FindBy(css=".product_list .product-container") // driver.findElements(By.cssSelector(".product_list .product-container"));
    List<WebElement> productsContainers;

    @FindBy(css = ".ajax_add_to_cart_button")
    List<WebElement> addToCartButtons;

    @FindBy(className = "continue")
    WebElement continueShoppingButton;

    @FindBy(linkText = "Proceed to checkout")
    WebElement proceedCheckoutButton;



    // we need create constructor to give 'static WebDriver driver;' from src/tests/java/tests/BaseTests
    public ProductsPage(WebDriver driverIn, WebDriverWait waitIn){
        super (driverIn, waitIn);
    }
    //
    public void moveMouseToProductContainer(int productIndex){
        // List<WebElement> productsContainers = driver.findElements(By.cssSelector(".product_list .product-container"));
        Actions builder = new Actions(driver);
        builder.moveToElement(productsContainers.get(productIndex)).build().perform(); // we must add ".build().perform();" every invoke moveToElement
    }

    public void addProductToTheBasket(int productIndex){
        // wait until element: "addToCartButtons.get(productIndex)" will be clickable
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons.get(productIndex)));
        // if is clickable > click
        addToCartButtons.get(productIndex).click();
        // wait until element: "continueShoppingButton" will be clickable
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        // if is clickable > click
        continueShoppingButton.click();
    }

    public void addProductToTheBasketAndProceedCheckout(int productIndex){
        // wait until element: "addToCartButtons.get(productIndex)" will be clickable
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons.get(productIndex)));
        // if is clickable > click
        addToCartButtons.get(productIndex).click();
        // wait until element: "proceedCheckoutButton" will be clickable
        wait.until(ExpectedConditions.elementToBeClickable(proceedCheckoutButton));
        // if is clickable > click
        proceedCheckoutButton.click();
        // now we see summary and we must click proceedCheckoutButton again to continue shopping
        proceedCheckoutButton.click();
        // now we are on LoginPage and we are ask to CREATE AN ACCOUNT or login by ALREADY REGISTERED? form.
    }

    public void addRandomProductToCart() {
        Random rnd = new Random();
        int productIndex = rnd.nextInt(productsContainers.size()); // set random number of product from showed product list.
        moveMouseToProductContainer(5); // we except that sixth element from the list will be clicked
        addProductToTheBasket(5); // we click on sixth element to add to the basket.
    }

    public void addRandomProductToCartAndProceedCheckout() {
        Random rnd = new Random();
        int productIndex = rnd.nextInt(productsContainers.size()); // set random number of product from showed product list.
        moveMouseToProductContainer(5); // we except that sixth element from the list will be clicked
        addProductToTheBasketAndProceedCheckout(5); // we click on sixth element to add to the basket.
    }
}
