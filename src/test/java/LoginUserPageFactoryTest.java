import PrestaShop.pageFactory.AccountPage;
import PrestaShop.pageFactory.LandingPage;
import PrestaShop.pageFactory.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

class LoginUserPageFactoryTest {

    private static final String EMAIL = "michal.dobrzycki@coderslab.pl";
    private static final String PASSWORD = "CodersLab";

    private WebDriver driver;

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void loginUserUsingPageFactory(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openPage();
        LoginPage loginPage = landingPage.signIn();
        AccountPage accountPage = loginPage.loginUser(EMAIL, PASSWORD);
        String actualUserName = accountPage.getUserName();
        String expectedUserName = "Automated Tester";
        Assertions.assertEquals(expectedUserName, actualUserName);

    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

}
