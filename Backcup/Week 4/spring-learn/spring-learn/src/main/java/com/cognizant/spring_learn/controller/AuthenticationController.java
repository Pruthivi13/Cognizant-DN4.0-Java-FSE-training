package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START");

        String user = getUser(authHeader);
        LOGGER.debug("Decoded Username: {}", user);

        String token = generateJwt(user);
        LOGGER.debug("Generated Token: {}", token);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        LOGGER.info("END");

        return map;
    }

    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.substring("Basic ".length());
        String decoded = new String(Base64.getDecoder().decode(encodedCredentials));
        String username = decoded.split(":")[0];
        return username;
    }

    private String generateJwt(String user) {
        try {
        	SecretKey key = Keys.hmacShaKeyFor("secretkeysecretkeysecretkey12345678".getBytes());


            return Jwts.builder()
                    .setSubject(user)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000))
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}