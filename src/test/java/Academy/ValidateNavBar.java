package Academy;
import resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import java.io.IOException;
public class ValidateNavBar {
    WebDriver driver;
    private  static Logger log= LogManager.getLogger(ValidateNavBar.class.getName());
    @BeforeTest
    public void driverSetUp() throws IOException {
        base bas=new base();
        driver=bas.initDriver();
        driver.get(bas.getUrl());
    }
    @Test
    public void basePageNavigation() throws IOException {

        LandingPage landingPage=new LandingPage(driver);
        Boolean bool =landingPage.getNavBar().isDisplayed();
        Assert.assertTrue(bool);
        log.info("Successfully validated Navigation bar");

    }
    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
