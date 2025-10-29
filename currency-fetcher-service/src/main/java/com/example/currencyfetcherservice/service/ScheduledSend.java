package com.example.currencyfetcherservice.service;

import com.example.currencyfetcherservice.DTO.CurrencyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduledSend {
    private final KafkaService kafkaService;
    private final RestService restService;

    @Scheduled(fixedRate = 300_000)
    public void sendScheduledMessage(){
        CurrencyDto currencyDto = restService.fetchRates("USD");
        kafkaService.sendMessage(currencyDto);
        log.info("send");
    }
}
