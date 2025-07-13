package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String username = "pruthivi";
        int loginAttempts = 5;

        logger.info("User {} has tried to login {} times", username, loginAttempts);
    }
}
