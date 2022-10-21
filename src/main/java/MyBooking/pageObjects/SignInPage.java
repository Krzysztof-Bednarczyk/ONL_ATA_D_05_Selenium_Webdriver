package MyBooking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    private final WebDriver driver;


    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public FormPage createUser(String email){
        WebElement emailInput = driver.findElement(By.id("email_create"));
        emailInput.sendKeys(email);
        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.submit();
        return new FormPage(driver);
    }

    public AccountPage loginUser(String email, String password){
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
        return new AccountPage(driver);
    }
}
