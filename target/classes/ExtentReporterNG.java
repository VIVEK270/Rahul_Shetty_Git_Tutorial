package resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;
public class ExtentReporterNG {
    static ExtentReports extentReports;
    @BeforeTest
    public static ExtentReports getReportObject(){
        String path=System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("VIVEK REPORT ON JUNIT TEST");
        sparkReporter.config().setDocumentTitle("VIVEK REPORT");
        sparkReporter.config().setTimelineEnabled(true);
        sparkReporter.config().setTimeStampFormat("12-12-1990");
        extentReports=new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("TESTER","VIVEK");
        return extentReports;
    }
}
