package MyBooking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage {

    private final WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountPage fillForm(String firstName, String lastName, String password){
        WebElement firstNameInput = driver.findElement(By.id("customer_firstname"));
        WebElement lastNameInput = driver.findElement(By.id("customer_lastname"));
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        WebElement registerButton = driver.findElement(By.id("submitAccount"));
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        passwordInput.sendKeys(password);
        registerButton.click();
        return new AccountPage(driver);
    }
}
