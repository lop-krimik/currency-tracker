package com.example.currencystorageservice.controller;


import com.example.currencystorageservice.domain.CurrencyStorageRate;
import com.example.currencystorageservice.service.CurrencyStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CurrencyStorage")
@RequiredArgsConstructor
public class CurrencyStorageController {

    private final CurrencyStorageService currencyStorageService;

//    @PostMapping("/saveCurrency")
//    public List<CurrencyStorageRate> store(CurrencyDto currencyDto, @RequestBody List<String> targetCurrencies){
//       return currencyStorageService.store(currencyDto);
//    }
    @GetMapping("/getAllRates")
        public List<CurrencyStorageRate> getAllRates(){
            return currencyStorageService.getAllRates();
    }

    @GetMapping("/getRatesByTarget")
        public List<CurrencyStorageRate> getRatesBytarget(@RequestParam List<String> targetCurrencies){
        return currencyStorageService.getRatesByTarget(targetCurrencies);
    }
}
