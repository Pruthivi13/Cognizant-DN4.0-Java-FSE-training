package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Stock;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StockService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Finds stocks based on dynamic filter criteria using Criteria API.
     * The filters map can contain keys like "code", "minClose", "maxClose", "startDate", "endDate", "minVolume", "maxVolume".
     *
     * @param filters Map of filter criteria
     * @return List of stocks matching the criteria
     */
    @Transactional(readOnly = true)
    public List<Stock> findStocksByCriteria(Map<String, Object> filters) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Stock> cq = cb.createQuery(Stock.class);
        Root<Stock> stock = cq.from(Stock.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filters.containsKey("code")) {
            predicates.add(cb.equal(stock.get("code"), filters.get("code")));
        }
        if (filters.containsKey("minClose")) {
            predicates.add(cb.greaterThanOrEqualTo(stock.get("close"), (BigDecimal) filters.get("minClose")));
        }
        if (filters.containsKey("maxClose")) {
            predicates.add(cb.lessThanOrEqualTo(stock.get("close"), (BigDecimal) filters.get("maxClose")));
        }
        if (filters.containsKey("startDate")) {
            predicates.add(cb.greaterThanOrEqualTo(stock.get("date"), (Date) filters.get("startDate")));
        }
        if (filters.containsKey("endDate")) {
            predicates.add(cb.lessThanOrEqualTo(stock.get("date"), (Date) filters.get("endDate")));
        }
        if (filters.containsKey("minVolume")) {
            predicates.add(cb.greaterThanOrEqualTo(stock.get("volume"), (Long) filters.get("minVolume")));
        }
        if (filters.containsKey("maxVolume")) {
            predicates.add(cb.lessThanOrEqualTo(stock.get("volume"), (Long) filters.get("maxVolume")));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
