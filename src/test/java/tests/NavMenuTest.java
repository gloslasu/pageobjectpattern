package tests;

import org.junit.jupiter.api.Test;
import pageobjects.BasePage;

public class NavMenuTest extends BaseTests{

    @Test
    void shouldMoveMouseOnWomenButton(){

        BasePage basePage = new BasePage(driver, wait);
        //basePage.moveMouseToMenuWomenButton();
    }

}
