package com.helper.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * Extent report configuration class
 *
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();


    /**
     * This method will create Extent Report > Spark Report
     * Ref: https://www.extentreports.com/docs/versions/4/java/spark-reporter.html
     * 
     * 
     * Report path can be defined under: 
     * root level = "./extent-reports/extent-report.html"
     * target folder = "target/extent-reports/extent-report.html"
     */
    public synchronized static ExtentReports createExtentSparkReports() {

        //Extent Spark Reporter
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/extent-reports/extent-report.html");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Team Prod Bug Test Report");

        //Attach Spark Reporter to Extent's Reporter
        extentReports.attachReporter(extentSparkReporter);
        
        //Generic System Info
        extentReports.setSystemInfo("Team", "Prod Bug");
        extentReports.setSystemInfo("Env", System.getProperty("env"));
        extentReports.setSystemInfo("Reporter", "Sheetal");
        
        return extentReports;
    }

}