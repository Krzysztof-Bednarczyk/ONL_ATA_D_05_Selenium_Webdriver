import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import MyBooking.pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

public class SubscribeToNewsletterTest {

    private WebDriver driver;

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    void subscribeToNewsletter(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage(); // otwieramy strone
        homePage.subscribeToNewsletter("test@test1234.com"); // subskrybujemy do newslettera
//        homePage.subscribeToNewsletter("mymail222@wp.pl"); // subskrybujemy do newslettera

        Assertions.assertTrue(homePage.verifySuccessAlertExists()); // veryfikujemy czy pojawił się alert
    }
}
