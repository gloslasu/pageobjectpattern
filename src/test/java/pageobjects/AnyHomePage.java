package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnyHomePage extends BasePage{

    public AnyHomePage(WebDriver driverIn, WebDriverWait waitIn){
        super (driverIn, waitIn);
    }

    public void openPage(){
        // Open main Page.
        driver.get(GOOGLE_URL);
    }


}
