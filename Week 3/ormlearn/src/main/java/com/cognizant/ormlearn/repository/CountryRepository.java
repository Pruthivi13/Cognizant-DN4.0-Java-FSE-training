package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findByNameContaining(String keyword);

    List<Country> findByNameContainingOrderByNameAsc(String keyword);

    List<Country> findByNameStartingWith(String letter);
}
