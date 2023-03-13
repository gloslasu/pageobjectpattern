package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginTest extends BaseTests {


//    @Test
//    void shouldRedirectToMyAccountPageWhenCorrectCredentialsAreUsed(){
//        // implementacja testu (korzystamy z metod LoginPage oraz MyAccountPage)
//
//    }

    // positive test
    @Test
    void shouldClickSignInButtonAndGoToLoginFormAndLogin(){

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.signInToRealAccount();
    }

    // negative test
    @Test
    void clickSignInButtonAndGoToLoginFormNegative(){
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage(); // Open main Page.

        BasePage basePage = new BasePage(driver, wait);
        basePage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.signInWithNotCorrectData();
        // assert
    }

    // logout Test
    @Test
    void ShouldLogOutAfterClickSignOutButton(){
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.signInToRealAccount();
        loginPage.clickSignOutButton(); // sign out and check if we are logout
    }


}
