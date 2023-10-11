package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomUser;

import java.util.List;

// here we put selectors and methods common to all subpages of our test application.
// we do that because we can see in automationpractice.com that footer and headers are the same on all subpages
public class BasePage {

    // @FindBy is Page Factory and extends Page Object
    @FindBy(id = "search_query_top")  // its tha same as driver.findElement(By.id("search_query_top"))
            WebElement searchBox;           // its tha same as driver.findElement(By.id("search_query_top"))

    @FindBy(css = ".menu-content>li>a")
    List<WebElement> productCategories; // List<WebElement> productCategories = driver.findElements(By.cssSelector(".menu-content>li>a"));

    @FindBy(css = ".shopping_cart .ajax_cart_quantity")
    WebElement cartQuantity;

    @FindBy(className = "login")
    WebElement signInButton;

//    @FindBy(linkText = "Women")
//    WebElement womenMenuButton;
//
//    @FindBy(linkText = "Dresses")
//    WebElement dressesMenuButton;
//
//    @FindBy(linkText = "T-shirts")
//    WebElement tshirtsMenuButton;


    WebDriver driver; // because our driver is here so every other class inherits this driver
    WebDriverWait wait;

    static final String BASE_URL = "http://automationpractice.com/";
    static final String GOOGLE_URL = "https://google.com/";

    static final String OTOMOTO_URL = "https://www.otomoto.pl";

    public BasePage(WebDriver driverIn, WebDriverWait waitIn){ // we need create constructor to give 'static WebDriver driver;' from src/tests/java/tests/BaseTests
        this.driver = driverIn; // driverIn is driver with comes from our method executed.
        this.wait = waitIn;
        // we must say in constructor that intelij should initialize and find elements @FindBy
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String productName){
        // write searching keyword in search box and enter.
        searchBox.sendKeys("dress"); // in search pool we type dress
        searchBox.sendKeys(Keys.ENTER); // confirm searching phrase with enter
    }

    // Menu: WOMEN | DRESSES | T-SHIRTS is available in all subpages so we can put method
    // opening selected category on our BasePage class:
    public void goProductCategoryByIndex(int productCategoryIndex){ // depending with we choose (WOMEN,DRESSES,T-SHIRTS) method will click on this what we choose.
        // we created locator to three elements on menu bar in @FindBy
        productCategories.get(productCategoryIndex).click(); // we click on forwarded "productCategoryIndex" in menu
    }

    public int getCartSize() {
        String cartQuantityText = cartQuantity.getText();
        return Integer.parseInt(cartQuantityText);
    }

    public void clickSignIn(){
        signInButton.click();
    }

    public void moveMouseToMenuWomenButton(int productCategoryIndex){
        Actions builder = new Actions(driver);
        // productCategories.builder.moveToElement.build().perform();

    }


}
