import MyBooking.pageObjects.AccountPage;
import MyBooking.pageObjects.HomePage;
import MyBooking.pageObjects.HotelSearchPage;
import MyBooking.pageObjects.SignInPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchForHotelTest {

    private static final String EMAIL = "johnybravo223@test.com";

    private static final String PASSWORD = "abcd1234";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    void searchForHotel() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.openPage().signIn();
        AccountPage accountPage = signInPage.loginUser(EMAIL, PASSWORD);
        homePage = accountPage.clickMyBookingLogo();
        HotelSearchPage hotelSearchPage = homePage.searchForHotel("22-10-2022", "26-10-2022");
        Assertions.assertTrue(hotelSearchPage.verifyGeneralRooms());
        String expectedText = "General Rooms";
        String actualText = hotelSearchPage.getGeneralRoomHeadingText();
        Assertions.assertEquals(expectedText, actualText);
    }
}
