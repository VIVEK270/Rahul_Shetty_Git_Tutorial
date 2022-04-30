package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LandingPage {
    WebDriver driver;
    //public WebDriver driver=bas.initDriver();
    By signin= By.cssSelector("a[href*='sign_in']");
    By header=By.xpath("//div[@class='col-md-6 text-left']/h2/span");
    By NavBar=By.xpath("(//ul[@class='navigation clearfix'])");
    public WebElement getLogin(){
        return driver.findElement(signin);
    }
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getHeader(){
        return driver.findElement(header);
    }
    public WebElement getNavBar()
    {
        return driver.findElement(NavBar);
    }

}