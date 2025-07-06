package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Additional custom queries can be defined here if needed
}
