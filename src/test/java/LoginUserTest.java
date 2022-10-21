import PrestaShop.pageObjects.AccountPage;
import PrestaShop.pageObjects.LandingPage;
import PrestaShop.pageObjects.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginUserTest {

    private static final String EMAIL = "michal.dobrzycki@coderslab.pl";
    private static final String PASSWORD = "CodersLab";

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
    void loginUserWithValidCredentials(){
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
