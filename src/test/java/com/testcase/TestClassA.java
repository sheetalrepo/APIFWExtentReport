package com.testcase;

import com.data.dataProvider.DataProviderClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * Example Test Class A w/o using Extent Report
 * 1. Basic Rest Assured
 * 2. Data Provider tests
 * 
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */

public class TestClassA extends BaseTestClass{

    @Test
    public void basicTestA1(){
        System.out.println("Running: TestClassA > basicTestA1");
        
        //Reading specific data from big CSV file
        Map<String, String> testdata = getCSVTestDataFor("basicTestA1");
        System.out.println("TC Test Data: "+ testdata);
        System.out.println("Username: "+ testdata.get("userName"));
        System.out.println("Hobbies: "+ testdata.get("hobbies").split("#")[1]);
        
        given()
            .get("http://jsonplaceholder.typicode.com/posts/3").
        then()
            .statusCode(200)
            .body("id",equalTo(3))
            .body("title",equalTo("ea molestias quasi exercitationem repellat qui ipsa sit aut"));

        System.out.println("============================================");
    }

    /**
     * Data can also be provided using Data Provider   
     */
    @Test(dataProvider = "listOfUserPassword", dataProviderClass = DataProviderClass.class)
    public void basicTestWithMultLogin(String username, String password){
        System.out.println("# "+username+ " & "+ password);
    }


}
