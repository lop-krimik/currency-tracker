package com.example.currencystorageservice.service;

import com.example.currencystorageservice.DTO.CurrencyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyConsumerService {
    private final CurrencyStorageService currencyStorageService;

    @KafkaListener(groupId = "currency-1", topics = "${topic.send-currency}")
    public void consume(CurrencyDto currencyDto){

        log.info("Consumed message: {}", currencyDto);
        currencyStorageService.store(currencyDto);
    }
}
