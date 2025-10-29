package com.example.currencystorageservice.Service;

import com.example.currencystorageservice.DTO.CurrencyDto;
import com.example.currencystorageservice.Domain.CurrencyStorageRate;
import com.example.currencystorageservice.Repository.CurrensyStorageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyStorageService {

    private final CurrensyStorageRepository currensyStorageRepository;

    public List<CurrencyStorageRate> store(CurrencyDto currencyDto){

        List<CurrencyStorageRate> currencyStorageRates = currencyDto.getConversion_rates().entrySet().stream()
                .map(entry -> {
                    CurrencyStorageRate currencyStorageRate = new CurrencyStorageRate();
                    currencyStorageRate.setBaseCode(currencyDto.getBase_code());
                    currencyStorageRate.setTargetCode(entry.getKey());
                    currencyStorageRate.setRate(BigDecimal.valueOf(entry.getValue()));

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
                    LocalDateTime timestamp = ZonedDateTime.parse(currencyDto.getTime_last_update_utc(), formatter)
                            .toLocalDateTime();
                    currencyStorageRate.setTimestamp(timestamp);
                    return currencyStorageRate;
                })
                .collect(Collectors.toList());

        return currensyStorageRepository.saveAll(currencyStorageRates);
    }

    public List<CurrencyStorageRate> getAllRates(){
        return currensyStorageRepository.findAll();
    }

    public List<CurrencyStorageRate> getRatesByTarget(List<String> targetCurrencies){
        return currensyStorageRepository.findByTargetCodeIn(targetCurrencies);
    }
}
