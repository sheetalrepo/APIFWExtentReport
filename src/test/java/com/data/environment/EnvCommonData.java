package com.data.environment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class will contain key-val pairs for common data from all environments. 
 * environment.yaml > allEnvData
 * 
 * URL =  baseurl + port + servicePath(if any) + endpoint
 * 
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
@Getter
@Setter
@ToString
public class EnvCommonData {
    String starShipPath;
    String planetPath;
}
