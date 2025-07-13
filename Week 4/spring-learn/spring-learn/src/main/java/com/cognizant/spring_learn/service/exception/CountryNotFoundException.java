package com.cognizant.spring_learn.service.exception;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException() {
        super("Country not found");
    }

   
    public CountryNotFoundException(String message) {
        super(message);
    }
}