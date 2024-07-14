package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;


    public void onTestStart(ITestResult result) {
        sparkReporter=new ExtentSparkReporter("Reports/TestReports.html");
        sparkReporter.config().setDocumentTitle("Reports");
        sparkReporter.config().setReportName("Users Todo Task Completion  more than 50%");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);

    }
    public void onTestSuccess(ITestResult result){
        test=extent.createTest(result.getName());
        test.log(Status.PASS,"Test case Passed:" + result.getName());

    }

    public void onTestFailure(ITestResult result){
        test=extent.createTest(result.getName());
        test.log(Status.FAIL,"Test case Failed:" + result.getName());
        test.log(Status.FAIL,"Test case Failure cause:" + result.getThrowable());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
