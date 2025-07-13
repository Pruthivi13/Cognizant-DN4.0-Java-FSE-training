package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultipleAppenders {
    private static final Logger logger = LoggerFactory.getLogger(MultipleAppenders.class);

    public static void main(String[] args) {
        logger.info("Logging to both console and file!");
    }
}
