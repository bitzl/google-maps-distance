package com.bitzl.open.data.distance.heatmap.config;

import com.bitzl.open.data.distance.heatmap.apis.GoogleDistanceApi;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleApiConfig {

    @Bean
    public GoogleDistanceApi googleDistanceApi() {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(GoogleDistanceApi.class, "https://maps.googleapis.com");
    }
}
