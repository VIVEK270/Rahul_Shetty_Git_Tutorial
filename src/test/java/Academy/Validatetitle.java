package Academy;
import resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import java.io.IOException;
public class Validatetitle  {
    WebDriver driver;
    private  static Logger log= LogManager.getLogger(Validatetitle.class.getName());
    @BeforeTest
    public void driverSetUp() throws IOException {
        base bas=new base();
        driver=bas.initDriver();
        log.info("Driver is initialized in ValidateTitle class");
        driver.get(bas.getUrl());
        log.info("Navigated to check Title");
    }
    @Test
    public void basePageNavigation() throws IOException {
        LandingPage landingPage=new LandingPage(driver);
        Assert.assertEquals(landingPage.getHeader().getText(),"An Academy to Learn Earn & Shine  in your QA");
        log.info("Successfully validated Title");
    }
    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
