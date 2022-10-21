package MyBooking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private static String SITE_URL = "https://hotel-testlab.coderslab.pl/en/";

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
}
