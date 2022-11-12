package PrestaShop.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private static final String URL = "https://mystore-testlab.coderslab.pl/index.php"; // adres strony

    private final WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LandingPage openPage(){
        driver.get(URL);
        return this;
    }

    @FindBy(css = "a[title='Log in to your customer account']")
    WebElement signInButton;

    public LoginPage signIn(){
        signInButton.click();
        return new LoginPage(driver);
    }
}
