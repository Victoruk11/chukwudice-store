package com.victoruk.chukwudice_store.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    Cloudinary cloudinary;
    private final String CLOUD_NAME = "dngxngp2u";

    private final String API_KEY = "915263922185462";

    private final String API_SECRETE = "NE1EH6XOOSGP-lyI4m60aIZoEWw";


    @Bean
    public Cloudinary cloudinary(){
        Map<String,String> config = new HashMap<>();
        config.put("cloud_name", CLOUD_NAME);
        config.put("api_key", API_KEY);
        config.put("apa_secrete", API_SECRETE);
        return new Cloudinary(config);


    }
}
