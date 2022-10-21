package MyBooking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public boolean verifyHotelIsAdded(){
        WebElement successAlert = driver.findElement(By.cssSelector(".layer_cart_product.col-xs-12.col-md-6 h2"));
        return successAlert.isDisplayed();
    }

    public String getSuccessAlertString(){
        WebElement successAlert = driver.findElement(By.cssSelector(".layer_cart_product.col-xs-12.col-md-6 h2"));
        return successAlert.getText();
    }
}
