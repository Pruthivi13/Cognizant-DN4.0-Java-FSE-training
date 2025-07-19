package com.cognizant.spring_learn.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = (Country) context.getBean("country");
        LOGGER.info("END");
        return country;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countryList = context.getBean("countryList", List.class);
        LOGGER.info("END");
        return countryList;
    }

    @GetMapping("/countries/{code}")
    public ResponseEntity<Object> getCountry(@PathVariable String code) {
        LOGGER.info("START");

        try {
            Country country = countryService.getCountry(code);
            LOGGER.info("END");
            return new ResponseEntity<>(country, HttpStatus.OK);

        } catch (CountryNotFoundException ex) {
            LOGGER.error("Country not found: {}", code);

            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("status", 404);
            body.put("error", "Not Found");
            body.put("message", ex.getMessage());
            body.put("path", "/countries/" + code);

            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }
}