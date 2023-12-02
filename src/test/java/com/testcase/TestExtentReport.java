package com.testcase;

import com.data.dataProvider.DataProviderClass;
import com.aventstack.extentreports.Status;
import io.restassured.response.Response;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.helper.extentReport.ExtentTestManager.getTest;
import static com.helper.extentReport.ExtentTestManager.startTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.lang.reflect.Method;

/**
 * Test class with all Extent Report features
 *
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
public class TestExtentReport extends BaseTestClass{


    @Test
    public void basicTest(Method method){
        //ExtentReports Method
        startTest(method.getName(), "Verify basicTest");
        getTest().assignCategory("Sanity").assignAuthor("Om").assignDevice("Android N23");

        Response response =
                given()
                        .get("http://jsonplaceholder.typicode.com/posts/3").
                then()
                        .statusCode(200)
                        .body("id",equalTo(3))
                        .body("title",equalTo("ea molestias quasi exercitationem repellat qui ipsa sit aut"))
                        .extract().response();

        //Print Logs in Extent Report
        getTest().log(Status.INFO, response.print());

        //TestNG Assertions 
        int userId = response.path("userId");
        int id = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("title");

        Assert.assertTrue(userId == 1, "userId should be 1");
        Assert.assertTrue(id == 3, "id should be 3");
        Assert.assertTrue(title.startsWith("ea molestias"), "id should be 3");
    }

    /**
     * Data can also be provided using Data Provider   
     */
    @Test(dataProvider = "listOfUserPassword", dataProviderClass = DataProviderClass.class)
    public void basicMultLoginTest(Method method,String username, String password){
        //ExtentReports Method
        startTest(method.getName(), "Verify basicMultLoginTest");
        getTest().assignCategory("Sanity").assignAuthor("Om").assignDevice("Android N23");

        System.out.println("# "+username+ " & "+ password);
    }

    @Test
    public void basicSmokeTest(Method method){
        //ExtentReports Method
        startTest(method.getName(), "Verify basicSmokeTest");
        getTest().assignCategory("Smoke").assignAuthor("Sheetal").assignDevice("iPhone 23");
        
        Assert.assertTrue(true);
    }

    @Test
    public void basicWarningTest(Method method){
        //ExtentReports Method
        startTest(method.getName(), "Verify basicWarningTest");
        getTest().assignCategory("Smoke").assignAuthor("Sheetal").assignDevice("Android N23");
        getTest().log(Status.WARNING, "Warning: This test case may fail as environment is not stable");
        
        Assert.assertTrue(true);

    }
    @Test
    public void basicFailureTest(Method method){
        //ExtentReports Method
        startTest(method.getName(), "Verify basicFailureTest");
        getTest().assignCategory("Regression").assignAuthor("Om").assignDevice("Android N23");

        try{
            int i = 10/0;
        }catch (Exception exception){
            getTest().log(Status.FAIL, ExceptionUtils.getStackTrace(exception));
            Assert.assertTrue(false, "Assertion failed");
        }
    }

    @Test
    public void basicAssertFailureTest(Method method){
        //ExtentReports Method
        startTest(method.getName(), "Verify basicAssertFailureTest");
        getTest().assignCategory("Regression").assignAuthor("Flower").assignDevice("Android N23");

        Assert.assertTrue(false, "Assertion should have been passed");

    }
    
    @Test
    public void basicSkipTest(Method method){
        //ExtentReports Method
        startTest(method.getName(), "Verify basicSkipTest");
        getTest().assignCategory("Regression").assignAuthor("Flower").assignDevice("Android N23");
        getTest().log(Status.SKIP, "Skipped: Feature is under development");
    }

}
