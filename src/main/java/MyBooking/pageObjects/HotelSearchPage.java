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
}
