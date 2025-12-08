package com.example.currencyanalyticsservice.service;

import com.example.currencyanalyticsservice.repository.CurrencyAnalyticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyAnalyticsService {

    private final CurrencyAnalyticsRepository currencyAnalyticsRepository;

    public Double averageBetweenDate(String targetCode, LocalDateTime beginDate, LocalDateTime endDate) {
        return currencyAnalyticsRepository.averageBetweenDate(targetCode, beginDate, endDate);
    }

    public Double averageAllTime(String targetCode) {
        return currencyAnalyticsRepository.averageAllTime(targetCode);
    }

    public Double maxValue(String targetCode) {
        return currencyAnalyticsRepository.maxValue(targetCode);
    }

    public Double minValue(String targetCode) {
        return currencyAnalyticsRepository.minValue(targetCode);
    }
    public Double currencyVolatility(String targetCode) {
        double avg = currencyAnalyticsRepository.averageAllTime(targetCode);
        List<Double> rate = currencyAnalyticsRepository.rate(targetCode);
        double volatilitySquare = rate.stream()
                .mapToDouble(r -> Math.pow(r + avg, 2))
                .average()
                .orElse(0.0);

        return Math.sqrt(volatilitySquare);
    }

    public String ratioPercentage(String targetCode, LocalDateTime beginTime, LocalDateTime endTime){
        double beginRate = currencyAnalyticsRepository.findRateByTimestamp(targetCode, beginTime);
        double endRate = currencyAnalyticsRepository.findRateByTimestamp(targetCode, endTime);

        Double delta = ((endRate - beginRate) / beginRate) * 100;
        return delta.toString();

    }
}
