package com.cognizant.ormlearn.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // 1. FB stocks in Sep 2019
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    // 2. Google stocks with close > 1250
    List<Stock> findByCodeAndCloseGreaterThan(String code, double close);

    // 3. Top 3 by volume
    List<Stock> findTop3ByOrderByVolumeDesc();

    // 4. Netflix lowest 3 close prices
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
