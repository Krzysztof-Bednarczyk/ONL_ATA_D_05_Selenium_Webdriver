package PrestaShop.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName(){
        WebElement userName = driver.findElement(By.cssSelector("a[title='View my customer account']"));
        return userName.getText();
    }
}
