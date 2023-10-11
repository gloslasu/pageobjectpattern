package tests;

import org.junit.jupiter.api.Test;
import pageobjects.BasePage;
import pageobjects.OtoMotoHomePage;
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
        OtoMotoHomePage otoMotoHomePage = new OtoMotoHomePage(driver, wait);
        otoMotoHomePage.navigateToOtoMotoMainPage(); // Open main Page.

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
