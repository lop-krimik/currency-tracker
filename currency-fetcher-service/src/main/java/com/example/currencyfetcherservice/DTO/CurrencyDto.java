package com.example.currencyfetcherservice.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDto {
   private String time_last_update_utc;
   private String base_code;
   private Map<String, Double> conversion_rates;

}
