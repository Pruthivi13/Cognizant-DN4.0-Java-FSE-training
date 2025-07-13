package com.cognizant.spring_learn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cognizant.spring_learn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.cognizant")
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");

        // Start Spring Boot Application
        SpringApplication.run(SpringLearnApplication.class, args);

        // ⛔ Removed these manual calls to avoid bean loading errors
        // new SpringLearnApplication().displayDate();
        // new SpringLearnApplication().displayCountry();

        LOGGER.info("END");
    }

    /*
    // ⚠ These manual XML-context-based methods are for testing only.
    // ⚠ Don't call them from main() in a Spring Boot app.

    public void displayDate() {
        LOGGER.info("START");

        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date);
        } catch (ParseException e) {
            LOGGER.error("Date parsing failed", e);
        }

        LOGGER.info("END");
    }

    public void displayCountry() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countryList = context.getBean("countryList", List.class);
        for (Country country : countryList) {
            LOGGER.debug("Country : {}", country);
        }
        LOGGER.info("END");
    }
    */
}