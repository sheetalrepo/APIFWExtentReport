package com.helper;

import com.data.environment.EnvPropertiesPlaceholder;
import org.yaml.snakeyaml.Yaml;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
public class ReadEnvironmentYaml {

    /**
     * This method will return env common data
     * @return EnvPropertiesPlaceholder object
     */
    public static EnvPropertiesPlaceholder getEnvironmentYamlFileCommonData(){
        String yamlPath = ".\\src\\test\\resources\\environment.yaml";
        Yaml yaml = new Yaml();

        EnvPropertiesPlaceholder environmentProperties = null;
        try {
            environmentProperties = yaml.loadAs(new FileReader(yamlPath), EnvPropertiesPlaceholder.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return environmentProperties;
    }

    /**
     * This method will load env specific data
     * @return HashMap for Env Specific Data
     */
    public static Map<String, String> loadEnvSpecificVariables(){
        EnvPropertiesPlaceholder environmentProperties = getEnvironmentYamlFileCommonData();

        //mvn clean test -DsuiteXmlFile="demoParam.xml" -Denv="sb"
        String runEnv = System.getProperty("env");
        System.out.println("#Env passed from cmd line: " + runEnv);
        
        //In case runEnv not passed from cmd line or running TCs directly from editor
        if(runEnv == null)
            runEnv = "prod";  //default env
        
        String environmentName;
        String environmentBaseUrl;
        if(runEnv.equalsIgnoreCase("prod")) {
            environmentName= environmentProperties.getAllEnvData().get(0).getEnvironmentName();
            environmentBaseUrl= environmentProperties.getAllEnvData().get(0).getEnvironmentValues().getBaseUrl();
        } else if(runEnv.equalsIgnoreCase("sb")) {
            environmentName= environmentProperties.getAllEnvData().get(1).getEnvironmentName();
            environmentBaseUrl= environmentProperties.getAllEnvData().get(1).getEnvironmentValues().getBaseUrl();
        } else {
            //default env = sb
            environmentName= environmentProperties.getAllEnvData().get(1).getEnvironmentName();
            environmentBaseUrl= environmentProperties.getAllEnvData().get(1).getEnvironmentValues().getBaseUrl();
        }

        
        //Env Specific Data loaded into HashMap
        Map<String, String> envSpecificData = new HashMap<>();
        envSpecificData.put("environmentName",environmentName);
        envSpecificData.put("environmentBaseUrl",environmentBaseUrl);

        return envSpecificData;
    }
}
