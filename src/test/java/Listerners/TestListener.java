//package Listerners;
//
//import Reports.ExtentManager;
//import Utilities.ScreenshotUtility;
//import base.BaseClass;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//public class TestListener implements ITestListener {
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        System.out.println("TEST STARTED: " + result.getName());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        System.out.println("TEST PASSED: " + result.getName());
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        BaseClass base =
//                (BaseClass) result.getInstance();
//        WebDriver driver = base.getDriver();
//        if (driver != null) {
//            String path = ScreenshotUtility.captureScreenshot(    ///screenshot
//                    driver, result.getName()
//            );
//            System.out.println("Screenshot saved: " + path);
//        }
//
//    }
//    ExtentReports extent = ExtentManager.getInstance();   ///Extent report
//    ExtentTest test;
//}


///---->after  adding extent report connecting all testng,screenshot,extent report


package Listerners;

import Reports.ExtentManager;
import Utilities.ScreenshotUtility;
import base.BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TestListener implements ITestListener,ISuiteListener { ///Isuie added after thread

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());

        System.out.println("TEST STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");        ///Records successful execution.

        System.out.println("TEST PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());         ////Records successful execution.

        BaseClass base = (BaseClass) result.getInstance();

        WebDriver driver = base.getDriver();

        if (driver != null) {

            String path = ScreenshotUtility.captureScreenshot(
                    driver, result.getName()
            );

            try {
                test.addScreenCaptureFromPath(path);  ///Records the failure and exception details.
            } catch (Exception e) {
                test.warning("Screenshot attachment failed: " + e.getMessage());
            }

            System.out.println("Screenshot saved: " + path);  ///screenshot
        }
    }

//    @Override
//    public void onFinish(ITestContext context) {
//
//        extent.flush();            /////Attaches your screenshot to the failed test's report.
//    }
@Override
public void onFinish(ISuite suite) {
    extent.flush();
}


}