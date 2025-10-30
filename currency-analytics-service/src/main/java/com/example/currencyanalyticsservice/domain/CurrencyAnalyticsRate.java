package com.example.currencyanalyticsservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "analytics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyAnalyticsRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baseCode;
    private String targetCode;
    private BigDecimal rate;
    private LocalDateTime timestamp;
}
