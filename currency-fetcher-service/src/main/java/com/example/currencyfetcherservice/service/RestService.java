package com.example.currencyfetcherservice.service;

import com.example.currencyfetcherservice.DTO.CurrencyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class RestService {
    private final RestClient restClient;
    @Value("${exchange-rate-api.key}")
    String apiKey;
    @Value("${exchange-rate-api.base-url}")
    String baseUrl;

    public CurrencyDto fetchRates(String baseCurrency){
        String URL = baseUrl + "/" + apiKey + "/latest/" + baseCurrency;
        return restClient.get()
                .uri(URL)
                .retrieve()
                .body(CurrencyDto.class);
    }
}