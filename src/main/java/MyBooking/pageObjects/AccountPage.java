package MyBooking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyAlert(){
        WebElement successAlert = driver.findElement(By.cssSelector(".alert.alert-success"));
        return successAlert.isDisplayed();
    }
}
