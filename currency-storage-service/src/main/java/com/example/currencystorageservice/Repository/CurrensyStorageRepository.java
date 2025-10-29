package com.example.currencystorageservice.Repository;

import com.example.currencystorageservice.Domain.CurrencyStorageRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrensyStorageRepository extends JpaRepository<CurrencyStorageRate, Long> {

    List<CurrencyStorageRate> findByTargetCodeIn(List<String> targetCurrencies);
}
