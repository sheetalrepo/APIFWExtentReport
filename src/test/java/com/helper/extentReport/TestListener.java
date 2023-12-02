package com.helper.extentReport;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static com.helper.extentReport.ExtentTestManager.getTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

/**
 * TestNG Listener Class
 * 
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
public class TestListener implements ITestListener {

    private static final Logger Log = LogManager.getLogger(TestListener.class);
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {}

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentManager.extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
       Log.info("Starting with Test: "+getTestMethodName(iTestResult));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        getTest().log(Status.PASS, "#Test Passed");
    }


    /**
     * In case any Assertion failed in any TCs, then this method will:
     *  - Print Assertion message given in TCs
     *  - Print Complete Stacktrace related to that assertion
     * 
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //iTestResult.getThrowable().printStackTrace();
        getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
        getTest().log(Status.FAIL, Arrays.toString(iTestResult.getThrowable().getStackTrace())); 
        getTest().log(Status.FAIL, "#Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        getTest().log(Status.SKIP, "#Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}
}