package com.business;

import com.data.environment.EnvPropertiesPlaceholder;
import com.helper.ReadEnvironmentYaml;
import java.util.Map;
import static com.helper.ReadEnvironmentYaml.getEnvironmentYamlFileCommonData;

/**
 * Business Layer:
 * All business related logic will come into these classes
 * Purpose is to keep TCs as short as possible
 * e.g. URL formation is not part of a TC and hence should come here
 * 
 * For POSTStarship
 * We can have another similar class or can add a new method in this class only
 * 
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
public class GetStarship {

    static Map<String, String> envSpecificData = ReadEnvironmentYaml.loadEnvSpecificVariables(); //environment.yaml
    static EnvPropertiesPlaceholder envCommonData = getEnvironmentYamlFileCommonData(); //environment.yaml
    
    
    public static String getStarshipURL(Map<String, String> testdata) {
        String envBaseUrl = envSpecificData.get("environmentBaseUrl");
        //String envBaseUrl = ReadEnvironmentYaml.loadEnvSpecificVariables().get("environmentBaseUrl");
        String starshipPath = envCommonData.getCommonData().getStarShipPath();
        String selectiveStatusURLRaw = envBaseUrl + starshipPath;

        String selectiveStatusURL = replaceId(selectiveStatusURLRaw, testdata.get("id"));
        System.out.println("#URL to be hit: "+selectiveStatusURL);
        return selectiveStatusURL;
    }

    public static String replaceId(String rawUrl, String id){
        return rawUrl.replaceAll("\\{id\\}",id);
    }
}
