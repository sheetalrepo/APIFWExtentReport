package com.testcase;

import com.data.environment.EnvPropertiesPlaceholder;
import com.helper.ReadCSVTestData;
import com.helper.ReadEnvironmentYaml;
import org.testng.annotations.BeforeSuite;
import java.util.HashMap;
import java.util.Map;
import static com.helper.ReadEnvironmentYaml.getEnvironmentYamlFileCommonData;

/**
 * This is the Base class for all the Test Classes
 * 
 * 
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
public class BaseTestClass {
    HashMap<String, HashMap<String, String>> csvTestDataAll; //HashMap<testcaseName, HashMap<Title, Value>>
    Map<String, String> envSpecificData; // Data specific to SB, Stage, Prod Env from environment.yaml
    EnvPropertiesPlaceholder envCommonData; // Common data like endpoints url from environment.yaml


    /**
     * Load everything in this method 
     */    
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("=============== Before Suite ===============");
        csvTestDataAll = ReadCSVTestData.getBigHashMapFromCSV();
        System.out.println("#Before Suite > Big CSV HM: "+ csvTestDataAll);

        envSpecificData = ReadEnvironmentYaml.loadEnvSpecificVariables(); 
        envCommonData = getEnvironmentYamlFileCommonData();
    }

    /**
     * This method will accept TC Name and return respective CSV Test Data
     */
    public Map<String, String> getCSVTestDataFor(String tcName) {
        Map<String, String> testdata = csvTestDataAll.get(tcName);
        return testdata;
    }
    
}
