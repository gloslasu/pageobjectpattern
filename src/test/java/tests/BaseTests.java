/*    This class contains methods:
   - @BeforeAll - initialization WebDriver
   - @BeforeEach - cleaning of cookies files
   - @AfterAll - closing WebDriver   */

package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    static WebDriver driver;

    @BeforeAll
    static void setUp(){
        // WebDriver drives a browser natively, like a user would be do it.
        driver = new ChromeDriver();

        // we must set timeouts because without this our tests will fail
        // Implicit wait: before every calling 'find element by..' we will wait 5 seconds to load all elements on the page.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // we need to open the page in full screen because if the page is responsive it looks different with different screen sizes
        driver.manage().window().setSize(new Dimension(1920, 1080)); // we open in full HD resolution
    }

    @BeforeEach
     void clearCookies(){
       driver.manage().deleteAllCookies();
    }

    @AfterAll
    static void turnDown(){
        driver.quit(); // close all tabs/windows and WebDriver
    }

}
