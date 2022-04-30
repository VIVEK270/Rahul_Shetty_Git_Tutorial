package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {
    public WebDriver driver;
    By email= By.cssSelector("input[id='email']");
    By pwd=By.cssSelector("input[id='password']");
    By btn=By.name("commit");

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPwd() {
        return driver.findElement(pwd);
    }


    public WebElement getBtn() {
        return driver.findElement(btn);
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
}
