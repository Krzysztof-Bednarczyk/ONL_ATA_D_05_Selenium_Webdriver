package PrestaShop.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    private static final String URL = "https://mystore-testlab.coderslab.pl/index.php"; // adres strony

    private final WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage openPage(){ // metoda otwierająca stronę
        driver.get(URL);
        return this; // zwracamy obiekt LandingPage, aby móc dalej na nim operować
    }

    public LoginPage signIn(){ // metoda, która naciska przycisk Sign Im
        WebElement signInButton = driver.findElement(By.cssSelector("a[title='Log in to your customer account']"));
        signInButton.click();
        return new LoginPage(driver); // zwracamy obiekt kolejnej strony, aby operować na nim
    }
}
