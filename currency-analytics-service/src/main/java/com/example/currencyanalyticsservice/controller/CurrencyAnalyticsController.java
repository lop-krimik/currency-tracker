package com.example.currencyanalyticsservice.controller;


import com.example.currencyanalyticsservice.service.CurrencyAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/CurrencyAnalytics")
public class CurrencyAnalyticsController {

    private final CurrencyAnalyticsService currencyAnalyticsService;

    @PostMapping("/averageBetweenDate")
    public Double averageBetweenDate(@RequestParam String targetCode,
                                     @RequestParam LocalDateTime beginDate,
                                     @RequestParam LocalDateTime endDate) {

        return currencyAnalyticsService.averageBetweenDate(targetCode, beginDate, endDate);

    }

    @PostMapping("/averageAllTime")
    public Double averageAllTime(@RequestParam String targetCode) {
        return currencyAnalyticsService.averageAllTime(targetCode);
    }

    @PostMapping("/maxValue")
    public Double maxValue(@RequestParam String targetCode) {
        return currencyAnalyticsService.maxValue(targetCode);
    }

    @PostMapping("/minValue")
    public Double minValue(@RequestParam String targetCode) {
        return currencyAnalyticsService.minValue(targetCode);
    }

    @PostMapping("/volatility")
    public Double currencyVolatility(@RequestParam String targetCode) {
        return currencyAnalyticsService.currencyVolatility(targetCode);
    }

    @PostMapping("/ratioPercentage")
    public String ratioPercentage(@RequestParam String targetCode,
                                  @RequestParam LocalDateTime beginTime,
                                  @RequestParam LocalDateTime endTime) {

        return currencyAnalyticsService.ratioPercentage(targetCode, beginTime, endTime);
    }


}
