package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomUser;

import java.util.List;
import java.util.Random;

public class RegisterPage extends BasePage{

    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    WebElement customerLastName;

    @FindBy(id = "id_gender1")
    WebElement customerGender1;

    @FindBy(id = "id_gender2")
    WebElement customerGender2;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement daysSelect;
    Select selectDays = new Select(daysSelect);

    @FindBy(id = "months")
    WebElement monthsSelect;
    Select selectMonths = new Select(monthsSelect);

    @FindBy(id = "years")
    WebElement yearsSelect;
    Select selectYears = new Select(yearsSelect);

//    @FindBy(id = "firstname")
//    WebElement customerFirstNameAgain = customerFirstName;
//
//    @FindBy(id = "lastname")
//    WebElement customerLastNameAgain;

    @FindBy(id = "address1")
    WebElement customerAddress;

    @FindBy(id = "city")
    WebElement customerCity;

    @FindBy(id = "id_state")
    WebElement customerStateSelect;
    Select stateSelect = new Select(customerStateSelect);

    @FindBy(id = "postcode")
    WebElement postCode;

    @FindBy(id = "phone_mobile")
    WebElement customerPhoneMobile;

    @FindBy(id = "alias")
    WebElement customerAlias;

    @FindBy(id = "submitAccount")
    WebElement submitAccountButton;

    @FindBy(className = "logout")
    WebElement signOutButton;

    @FindBy(className = "alert-danger")
    WebElement errorsAlert;



    public RegisterPage(WebDriver driverIn, WebDriverWait waitIn) {
        super(driverIn, waitIn);
    }

    public void registerUser(RandomUser user) throws InterruptedException {
        RandomGender();
        customerFirstName.sendKeys(user.firstName);
        customerLastName.sendKeys(user.lastName);
        password.sendKeys(user.password);
        selectDays.selectByIndex(1);
        selectMonths.selectByIndex(1);
        selectYears.selectByIndex(1);
        // customerFirstNameAgain.sendKeys(user.firstName);
        customerAddress.sendKeys(user.address1);
        customerCity.sendKeys(user.city);
        stateSelect.selectByIndex(1);
        postCode.sendKeys(user.zipCode);
        customerPhoneMobile.sendKeys(user.phoneNumber);
        customerAlias.sendKeys(user.firstName);
        submitAccountButton.click();
        Assertions.assertEquals(signOutButton.getText(), "Sign out");
        Thread.sleep(8000);
    }

    // negative registration when one of all pool in not fill (commented pool is not fill)
    public void doNotRegisterUser(RandomUser user) throws InterruptedException {
        RandomGender();
        customerFirstName.sendKeys(user.firstName);
        customerLastName.sendKeys(user.lastName);
        password.sendKeys(user.password);
        selectDays.selectByIndex(1);
        selectMonths.selectByIndex(1);
        selectYears.selectByIndex(1);
        customerAddress.sendKeys(user.address1);
        customerCity.sendKeys(user.city);
        stateSelect.selectByIndex(1);
        // postCode.sendKeys(user.zipCode); // we don't fill this pool
        customerPhoneMobile.sendKeys(user.phoneNumber);
        customerAlias.sendKeys(user.firstName);
        submitAccountButton.click();
        Assertions.assertTrue(errorsAlert.isDisplayed()); // when we see alert "There are x errors" it's mean that is ok
        Thread.sleep(8000);
    }

    public void RandomGender(){
        Random rnd = new Random();
        int gender = rnd.nextInt(2);
        if (gender == 0){
            customerGender1.click();
        } else{
            customerGender2.click();
        }
    }



}
