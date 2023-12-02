package com.helper.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;


/**
 * extentTestMap holds the information of thread ids and ExtentTest instances.
 *
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
public class ExtentTestManager {
    static ExtentReports extentSparkReports = ExtentManager.createExtentSparkReports();
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>(); // <thread_id, extentTest>

    /**
     * Method to be called in every @test method
     * an instance of ExtentTest created and put into extentTestMap with current thread id.
     */
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extentSparkReports.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }

    /**
     * Method to be called in every @test method
     * return ExtentTest instance in extentTestMap by using current thread id.
     */
    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }
}