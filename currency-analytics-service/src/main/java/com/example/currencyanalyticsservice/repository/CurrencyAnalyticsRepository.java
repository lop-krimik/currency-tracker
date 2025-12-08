package com.example.currencyanalyticsservice.repository;

import com.example.currencyanalyticsservice.domain.CurrencyAnalyticsRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CurrencyAnalyticsRepository extends JpaRepository<CurrencyAnalyticsRate, Long> {

    @Query("SELECT AVG(c.rate) FROM CurrencyAnalyticsRate c WHERE c.targetCode =:target" +
            " AND c.timestamp BETWEEN :begin_date AND :end_date")
     Double averageBetweenDate(@Param("target") String target,
                    @Param("begin_date")LocalDateTime beginDate,
                    @Param("end_date") LocalDateTime endDate);

    @Query("SELECT AVG(c.rate) FROM CurrencyAnalyticsRate c WHERE c.targetCode =:target")
    Double averageAllTime(@Param("target") String targetCode);

    @Query("SELECT MAX(c.rate) FROM CurrencyAnalyticsRate c WHERE c.targetCode =:target")
    Double maxValue(@Param("target") String targetCode);

    @Query("SELECT MIN(c.rate) FROM CurrencyAnalyticsRate c WHERE c.targetCode =:target")
    Double minValue(@Param("target") String targetCode);

    @Query("SELECT c.rate FROM CurrencyAnalyticsRate c WHERE c.targetCode =:target")
    List<Double> rate(@Param("target") String targetCode);

    @Query("SELECT c.rate FROM CurrencyAnalyticsRate c WHERE c.targetCode =:target AND c.timestamp =:time")
    Double findRateByTimestamp(@Param("target") String targetCode, @Param("time") LocalDateTime time);
}
