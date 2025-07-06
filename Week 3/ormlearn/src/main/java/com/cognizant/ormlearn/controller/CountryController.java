package com.cognizant.ormlearn.controller;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // ✅ Get all countries
    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    // ✅ Get country by code
    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
        return countryService.findCountryByCode(code);
    }

    // ✅ Add a new country
    @PostMapping
    public void addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
    }

    // ✅ Update country
    @PutMapping("/{code}")
    public void updateCountry(@PathVariable String code, @RequestBody Country updatedCountry)
            throws CountryNotFoundException {
        countryService.updateCountry(code, updatedCountry.getName());
    }

    // ✅ Delete country
    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) throws CountryNotFoundException {
        countryService.deleteCountry(code);
    }

    // ✅ Search countries by name
    @GetMapping("/search")
    public List<Country> searchCountries(@RequestParam String keyword) {
        return countryService.findByNameContaining(keyword);
    }
}
