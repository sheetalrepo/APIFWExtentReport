package com.data.environment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * This class will contain key-val pairs for all environments.
 * environment.yaml > allEnvData > envValues
 *
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
@Getter
@Setter
@ToString
public class EnvValues {
    String baseUrl;
    int port;
}
