package tests;

import org.junit.jupiter.api.Test;
import pageobjects.OtoMotoHomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import utils.RandomUser;

public class RegisterTest extends BaseTests{

    @Test
    void shouldRegisterNewUserWhenAllMandatoryDataIsProvided() throws InterruptedException { // positive registration

        RandomUser user = new RandomUser();
        System.out.println(user); // we print used user to test. It's needed as log for tests.

        OtoMotoHomePage otoMotoHomePage = new OtoMotoHomePage(driver, wait);
        otoMotoHomePage.navigateToOtoMotoMainPage(); // Open main Page.

        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.goToRegisterForm();

        RegisterPage registerPage = new RegisterPage(driver,wait);
        registerPage.registerUser(user);
    }

    // negative registration when one of all pool in not fill
    @Test
    void shouldNotRegisterNewUserWhenAlmostAllMandatoryDataIsProvided() throws InterruptedException { // positive registration

        RandomUser user = new RandomUser();
        System.out.println(user); // we print used user to test. It's needed as log for tests.

        OtoMotoHomePage otoMotoHomePage = new OtoMotoHomePage(driver, wait);
        otoMotoHomePage.navigateToOtoMotoMainPage(); // Open main Page.

        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.goToRegisterForm();

        RegisterPage registerPage = new RegisterPage(driver,wait);
        registerPage.doNotRegisterUser(user);
    }

}
