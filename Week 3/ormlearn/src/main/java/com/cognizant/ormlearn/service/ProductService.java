package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.dto.ProductFilter;
import com.cognizant.ormlearn.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Finds products based on dynamic filter criteria using Criteria API.
     * The filters map can contain keys like "operatingSystem", "ram", "cpu", "minCpuSpeed", "maxCpuSpeed".
     *
     * @param filters Map of filter criteria
     * @return List of products matching the criteria
     */
    @Transactional(readOnly = true)
    public List<Product> findProductsByCriteria(java.util.Map<String, Object> filters) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filters.containsKey("operatingSystem")) {
            predicates.add(cb.equal(product.get("operatingSystem"), filters.get("operatingSystem")));
        }
        if (filters.containsKey("ram")) {
            predicates.add(cb.equal(product.get("ram"), filters.get("ram")));
        }
        if (filters.containsKey("cpu")) {
            predicates.add(cb.equal(product.get("cpu"), filters.get("cpu")));
        }
        if (filters.containsKey("minCpuSpeed")) {
            predicates.add(cb.greaterThanOrEqualTo(product.get("cpuSpeed"), (Double) filters.get("minCpuSpeed")));
        }
        if (filters.containsKey("maxCpuSpeed")) {
            predicates.add(cb.lessThanOrEqualTo(product.get("cpuSpeed"), (Double) filters.get("maxCpuSpeed")));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Product> searchProducts(ProductFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filter.getKeyword() != null && !filter.getKeyword().isEmpty()) {
            String pattern = "%" + filter.getKeyword().toLowerCase() + "%";
            predicates.add(cb.like(cb.lower(product.get("name")), pattern));
        }
        if (filter.getOperatingSystem() != null && !filter.getOperatingSystem().isEmpty()) {
            predicates.add(cb.equal(product.get("operatingSystem"), filter.getOperatingSystem()));
        }
        if (filter.getRamSize() != null) {
            String ramStr = filter.getRamSize() + " GB";
            predicates.add(cb.equal(product.get("ram"), ramStr));
        }
        if (filter.getCpu() != null && !filter.getCpu().isEmpty()) {
            predicates.add(cb.equal(product.get("cpu"), filter.getCpu()));
        }
        if (filter.getMinCpuSpeed() != null) {
            predicates.add(cb.greaterThanOrEqualTo(product.get("cpuSpeed"), filter.getMinCpuSpeed()));
        }
        if (filter.getMaxWeight() != null) {
            // Assuming product has weight field, if not ignore
            predicates.add(cb.lessThanOrEqualTo(product.get("weight"), filter.getMaxWeight()));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
