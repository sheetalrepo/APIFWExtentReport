package com.testcase;

import com.business.GetStarship;
import com.pojos.response.StarshipPlaceholder;
import org.testng.annotations.Test;
import static com.helper.extentReport.ExtentTestManager.getTest;
import static com.helper.extentReport.ExtentTestManager.startTest;
import java.lang.reflect.Method;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import com.aventstack.extentreports.Status;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.lang.reflect.Method;

/**
 * Example Test Class B
 * Test Class using POJOs for Deserialization, YAML to read properties etc
 * Complete usage of API FW
 * Extent Report
 * 
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */

public class TestClassB extends BaseTestClass{

    @Test
    public void basicTestB1(Method method){
        //ExtentReports Method
        startTest(method.getName(), "Verify basicTestB1");
        getTest().assignCategory("Regression").assignAuthor("Sheetal").assignDevice("Android N23");

        System.out.println("#Running: basicTestB1");

        Map<String, String> testdata = getCSVTestDataFor("basicTestB1");
        System.out.println("#TC Test Data: "+ testdata);

        String starshipURL = GetStarship.getStarshipURL(testdata);
        
        //Rest Assured
        Response response =
                given()
                        .headers("Accept-Language","de-DE")
                        .param("jobs","fuelStatus").
                        //.headers("Authorization","Bearer "+bearerToken).
                when()
                        .get(starshipURL).
                then()
                        .statusCode(200).log().all()
                        .extract().response();


        //Deserialization
        StarshipPlaceholder responseObj = response.as(StarshipPlaceholder.class);

        //Verification using Deserialization
        String film = responseObj.getFilms().get(2);
        String passengers = responseObj.getPassengers();
        Assert.assertTrue(film.contains("/films/6/"), "film url is not correct");
        Assert.assertTrue(passengers.equals("600"), "passengers count is not correct");

        //Verification w/o using Deserialization
        JsonPath jsonPath= response.jsonPath();
        String film2 = jsonPath.getList("films").get(2).toString();
        String passengers2 = jsonPath.getString("passengers");
        Assert.assertTrue(film2.contains("/films/6/"), "film url is not correct");
        Assert.assertTrue(passengers2.equals("600"), "passengers count is not correct");

        //Print Logs in Extent Report
        getTest().log(Status.INFO, "ETag: "+response.header("ETag"));
        getTest().log(Status.INFO, response.print());

        System.out.println("============================================");
    }



    


    }
