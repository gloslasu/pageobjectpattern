package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OtoMotoHomePage extends BasePage{

    @FindBy(css = "button[id*='onetrust-accept-btn-handler']")
    private WebElement cartQuantity;

    @FindBy(css = "input[placeholder='Marka pojazdu']")
    private WebElement btnBrandOfCar;


    @FindBy(xpath = "//span[contains(text(), 'Alfa')]")
    private WebElement alfaRomeo;


    public OtoMotoHomePage(WebDriver driverIn, WebDriverWait waitIn){
        super (driverIn, waitIn);
    }


    public void navigateToOtoMotoMainPage(){
        driver.get(OTOMOTO_URL);
    }


    public void clickAcceptCookiesButton() {
        cartQuantity.click();
    }

    public void selectItemOnCarBrandList() {
        btnBrandOfCar.click();
        alfaRomeo.click();
    }





}
