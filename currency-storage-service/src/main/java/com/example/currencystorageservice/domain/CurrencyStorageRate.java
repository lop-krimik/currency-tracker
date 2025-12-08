package com.example.currencystorageservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CurrencyRate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyStorageRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baseCode;
    private String targetCode;
    private BigDecimal rate;
    private LocalDateTime timestamp;
}
