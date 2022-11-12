package PrestaShop.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountPage loginUser(String email, String password){
        WebElement emailInput = driver.findElement(By.cssSelector("input[class='form-control']"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("submit-login"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.submit();
        return new AccountPage(driver);
    }
}
