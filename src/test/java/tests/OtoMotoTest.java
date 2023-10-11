package tests;

import pageobjects.OtoMotoHomePage;
import org.junit.jupiter.api.Test;


public class OtoMotoTest extends BaseTests{

@Test
   public void searchCarTest(){
        openOtoMotoMainPage();
        clickAcceptCookiesButton();
        selectItemOnCarBrandList();
     }

   public void openOtoMotoMainPage() {
        OtoMotoHomePage otoMotoHomePage = new OtoMotoHomePage(driver, wait);
        otoMotoHomePage.navigateToOtoMotoMainPage();
     }

   private void clickAcceptCookiesButton() {
        OtoMotoHomePage otoMotoHomePage = new OtoMotoHomePage(driver, wait);
        otoMotoHomePage.clickAcceptCookiesButton();
      }

    private void selectItemOnCarBrandList() {
        OtoMotoHomePage otoMotoHomePage = new OtoMotoHomePage(driver, wait);
        otoMotoHomePage.selectItemOnCarBrandList();
    }





}
