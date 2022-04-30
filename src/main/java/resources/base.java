package resources;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
public class base {
    public WebDriver driver;public Properties properties;
    public WebDriver initDriver() throws IOException {
                properties=new Properties();
                FileInputStream  fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
                properties.load(fs);
                String browser=properties.getProperty("browser");
                if (browser.equals("chrome")){
                    System.setProperty("webdriver.chrome.driver","C:\\Users\\Vivek\\Downloads\\chromedriver_win32\\chromedriver.exe");
                    ChromeOptions options=new ChromeOptions();
                    options.addArguments("headless");
                    options.setAcceptInsecureCerts(true);
                    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
                     driver=new ChromeDriver(options);
                     driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
                     return driver;
                }
                //mvn test -Dbrowser=chrome
        //System.getProperty(browser)-->TO get prop from Jenkins
        //test -Dbrowser="$browser"
        return null;
    }
    public String getUrl(){
        return properties.getProperty("url");
    }
    public String getScreenShotPath(String testCaseNmae, WebDriver driver) throws IOException {
        TakesScreenshot ts =(TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destFile=System.getProperty("user.dir")+"\\reports\\"+testCaseNmae+".png";
        FileUtils.copyFile(source, new File(destFile));
        return destFile;
    }
}
