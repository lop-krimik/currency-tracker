package com.example.currencyfetcherservice.service;

import com.example.currencyfetcherservice.DTO.CurrencyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final KafkaTemplate<String, CurrencyDto> kafkaTemplate;
    @Value("${topic.send-currency}")
    private String topic;

    public void sendMessage(CurrencyDto currencyDto){
        kafkaTemplate.send(topic, currencyDto);
    }
}
