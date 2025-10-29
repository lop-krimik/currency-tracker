package com.example.currencystorageservice.DTO;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyDto {
    private String time_last_update_utc;
    private String base_code;
    private Map<String, Double> conversion_rates;

}