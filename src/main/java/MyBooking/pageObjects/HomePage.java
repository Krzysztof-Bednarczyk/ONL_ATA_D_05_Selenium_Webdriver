package MyBooking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;
    private static final String SITE_URL = "https://hotel-testlab.coderslab.pl/en/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage openPage(){
        driver.get(SITE_URL);
        return this;
    }


    public HomePage subscribeToNewsletter(String email){
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);
        WebElement subscribeButton = driver.findElement(By.name("submitNewsletter"));
        subscribeButton.click();
        return this;
    }

    public boolean verifySuccessAlertExists(){
        WebElement successAlert = driver.findElement(By.cssSelector(".alert.alert-success"));
        return successAlert.isDisplayed();
    }
    public SignInPage signIn(){
        WebElement signInButton = driver.findElement(By.className("user_login"));
        signInButton.click();
        return new SignInPage(driver);
    }

    public HotelSearchPage searchForHotel(String checkinDate, String checkoutDate){
        WebElement dropdown = driver.findElement(By.id("hotel_cat_name"));
        dropdown.click();
        WebElement hotelPrime = driver.findElement(By.className("hotel_name"));
        hotelPrime.click();
        WebElement checkInTimeInput = driver.findElement(By.id("check_in_time"));
        WebElement checkoutTimeInput = driver.findElement(By.id("check_out_time"));
        checkInTimeInput.sendKeys(checkinDate);
        checkoutTimeInput.sendKeys(checkoutDate);
        WebElement searchNowButton = driver.findElement(By.id("search_room_submit"));
        searchNowButton.click();
        return new HotelSearchPage(driver);
    }
}
