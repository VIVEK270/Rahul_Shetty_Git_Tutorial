package Academy;
import resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
public class HomePage {
    public WebDriver driver;        base bas=new base();

    private  static Logger log= LogManager.getLogger(HomePage.class.getName());
    @BeforeTest
     public void driverSetUp() throws IOException {
        System.out.println("before test");
         driver=bas.initDriver();
    }
    public HomePage() throws IOException {
    }
    @Test(dataProvider = "getData")
    public void basePageNavigation(String name,String pwd,String text) throws IOException, InterruptedException {
        driver.get(bas.getUrl());
        LandingPage landingPage=new LandingPage(driver);
        landingPage.getLogin().click();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getEmail().sendKeys(name);
        loginPage.getPwd().sendKeys(pwd);
        log.info(text);
        loginPage.getBtn().click();
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> set=driver.getWindowHandles();
        Iterator<String> iterator=set.iterator();
        String parentWindow=iterator.next();
        String childWindow=iterator.next();
        driver.switchTo().window(childWindow);
        log.info("SUCCESS IN HOME PAGE VALIDATION");
    }
    @AfterTest
    public void closeDriver(){
        driver.close();
    }
    @DataProvider
    public Object[][] getData(){
        //ROWS-->HOW MANY DATA//col-->how many values per each test
        Object[][] data = new Object[2][3];
        data[0][0]="abc@tcs.com";
        data[0][1]="12345";
        data[0][2]="RESTRICTED USER";
        data[1][0]="restriceduser@ejd.com";
        data[1][1]="333";
        data[1][2]="NON RESTRICTED USER";
        return data;
    }
}