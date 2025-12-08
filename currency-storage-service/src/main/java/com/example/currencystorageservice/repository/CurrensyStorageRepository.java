package com.example.currencystorageservice.repository;

import com.example.currencystorageservice.domain.CurrencyStorageRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrensyStorageRepository extends JpaRepository<CurrencyStorageRate, Long> {

    List<CurrencyStorageRate> findByTargetCodeIn(List<String> targetCurrencies);
}
