package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    public HomePage(WebDriver driverIn, WebDriverWait waitIn){
        super (driverIn, waitIn);
    }

    public void openPage(){
        // Open main Page.
        driver.get(BASE_URL + "index.php");
    }


}
