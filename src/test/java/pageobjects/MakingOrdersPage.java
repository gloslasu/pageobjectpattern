package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class MakingOrdersPage extends BasePage{


    @FindBy(how = How.NAME, using = "processAddress")
    private WebElement proceedToCheckout;

    @FindBy(id = "uniform-cgv")
    WebElement termsOfServiceCheckBox;

    @FindBy(how = How.NAME, using = "processCarrier")
    private WebElement proceedToCheckoutAgain;

    @FindBy(className = "bankwire")
    WebElement payByBankWireButton;

    @FindBy(className = "cheque")
    WebElement payByCheckButton;

    @FindBy(xpath = "//button[@type='submit' and contains(., 'confirm ')]")
    private WebElement iConfirmMyOrderButton;

//    @FindBy(xpath = "//p[@class='alert' and contains(., 'success ')]")
//    private WebElement iConfirmMyOrderButton;



    public MakingOrdersPage(WebDriver driverIn, WebDriverWait waitIn) {
        super(driverIn, waitIn);
    }

    public void finishOrder() {
        proceedToCheckout.click();
        termsOfServiceCheckBox.click();
        proceedToCheckoutAgain.click();
        RandomPaymentButton();
        iConfirmMyOrderButton.click();

    }

    public void RandomPaymentButton(){
        Random rnd = new Random();
        int gender = rnd.nextInt(2);
        if (gender == 0){
            payByBankWireButton.click();
        } else{
            payByCheckButton.click();
        }
    }


}
