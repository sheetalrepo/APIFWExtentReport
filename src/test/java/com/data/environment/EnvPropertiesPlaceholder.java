package com.data.environment;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class will contain complete data from environment.yaml
 * 
 * Imp: obj name in this class shd match with environment.yaml
 *
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
@Getter
@Setter
@ToString
public class EnvPropertiesPlaceholder {
    List<EnvSpecificData> allEnvData;    
    EnvCommonData commonData;
}
