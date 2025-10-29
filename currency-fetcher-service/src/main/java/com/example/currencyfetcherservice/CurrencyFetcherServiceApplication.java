package com.example.currencyfetcherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class CurrencyFetcherServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyFetcherServiceApplication.class, args);
    }

}
