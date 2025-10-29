package com.example.currencyfetcherservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
//import org.springframework.web.client.RestClient;

@Configuration
public class RestConfiguration {

    @Bean
    public RestClient restClient(){
        return RestClient.create();
    }
}
