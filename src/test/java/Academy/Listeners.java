package Academy;
import com.aventstack.extentreports.ExtentReports;
    import com.aventstack.extentreports.ExtentTest;
    import com.aventstack.extentreports.Status;
    import org.openqa.selenium.WebDriver;
    import org.testng.ITestContext;
    import org.testng.ITestListener;
    import org.testng.ITestResult;
    import resources.ExtentReporterNG;
    import resources.base;
    import java.io.IOException;
public class Listeners implements ITestListener {
    base bas=new base();
    ExtentTest test;
    ExtentReports extentReports= ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> threadLocal = new ThreadLocal();
    @Override
    public void onTestStart(ITestResult iTestResult) {
       test=extentReports.createTest(iTestResult.getMethod().getMethodName());
       threadLocal.set(test);
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
              threadLocal.get().log(Status.PASS,"Test Passed");
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        threadLocal.get().fail(iTestResult.getThrowable());
        WebDriver driver=null;
        System.out.println("FAILURE FROM ITESTLISTENER  "+iTestResult.getName()+" is the test case name ");
         String failedCase=iTestResult.getMethod().getMethodName();
        try {
            driver= (WebDriver) iTestResult.getTestClass().getRealClass().getDeclaredField("driver").get(iTestResult.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bas.getScreenShotPath(failedCase,driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            threadLocal.get().addScreenCaptureFromPath(bas.getScreenShotPath(failedCase,driver),iTestResult.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
    @Override
    public void onStart(ITestContext iTestContext) {

    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
    }
}
