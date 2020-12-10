package pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    // we need create constructor to give 'static WebDriver driver;' from src/tests/java/tests/BaseTests
    public HomePage(WebDriver driverIn){
    this.driver = driverIn; // driverIn is driver with comes from our method executed.
    }

   public void openPage(){
        // Open main Page.
        driver.get(BASE_URL + "index.php");
    }

}
