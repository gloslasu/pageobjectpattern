package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomUser;

public class LoginPage extends BasePage{

    String currentURL = driver.getCurrentUrl();

    @FindBy(id = "email")
    WebElement emailAddressField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @FindBy(className = "logout")
    public WebElement signOutButton;

    @FindBy(id = "email_create")
    WebElement createAnAccountEmailAddressFiled;

    @FindBy(id = "SubmitCreate")
    WebElement createAnAccountButton;


//    @FindBy(css = "logout")
//    WebElement authenticationFailedAlert;


    public LoginPage(WebDriver driverIn, WebDriverWait waitIn) {
        super(driverIn, waitIn);
    }


    public void signInToRealAccount(){

        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage(); // Open main Page.

        BasePage basePage = new BasePage(driver, wait);
        basePage.clickSignIn();

        emailAddressField.sendKeys("test@softie.pl"); // negative
        passwordField.sendKeys("1qaz!QAZ");
        signInButton.click();
        Assertions.assertEquals(signOutButton.getText(), "Sign out");
    }

    public void signInWithNotCorrectData(){
        RandomUser user = new RandomUser();
        emailAddressField.sendKeys(user.email);
        passwordField.sendKeys(user.password);
        signInButton.click();
        // Assertions.assertEquals(authenticationFailedAlert.getText(), "Authentication failed.");
    }


    public void goToRegisterForm(){
        RandomUser user = new RandomUser();
        clickSignIn();
        createAnAccountEmailAddressFiled.sendKeys(user.email);
        createAnAccountButton.click();
        //Thread.sleep(10000);
    }

    public void continueOrderShouldAddProductToTheBasketAndBuyThroughRegisterForm() {
        RandomUser user = new RandomUser();
        createAnAccountEmailAddressFiled.sendKeys(user.email);
        createAnAccountButton.click();
        //Thread.sleep(10000);
    }

    // logout
    public void clickSignOutButton(){
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.signOutButton.click();
        Assertions.assertEquals(currentURL, "automationpractice.com/index.php" );
    }



}
