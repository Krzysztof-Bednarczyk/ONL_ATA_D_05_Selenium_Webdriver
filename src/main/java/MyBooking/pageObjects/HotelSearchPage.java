package MyBooking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class HotelSearchPage {

    public final WebDriver driver;

    public HotelSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyGeneralRooms(){
        List<WebElement> roomHeadings = driver.findElements(By.className("rm_heading"));
        WebElement generalRoomsHeading = roomHeadings.get(0);
        return generalRoomsHeading.isDisplayed();
    }

    public String getGeneralRoomHeadingText(){
        List<WebElement> roomHeadings = driver.findElements(By.className("rm_heading"));
        WebElement generalRoomsHeading = roomHeadings.get(0);
        return generalRoomsHeading.getText();
    }

    public void bookHotel(int index){
        List<WebElement> bookingButton = driver.findElements(By.cssSelector(".ajax_add_to_cart_button"));
        bookingButton.get(index).click();
    }

    public boolean verifyHotelIsAdded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, SECONDS));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#layer_cart[style*='display: block']")));
        WebElement successAlert = driver.findElement(By.cssSelector(".layer_cart_product.col-xs-12.col-md-6 h2"));
        return successAlert.isDisplayed();
    }

    public String getSuccessAlertString(){
        WebElement successAlert = driver.findElement(By.cssSelector(".layer_cart_product.col-xs-12.col-md-6 h2"));
        return successAlert.getText();
    }
}
