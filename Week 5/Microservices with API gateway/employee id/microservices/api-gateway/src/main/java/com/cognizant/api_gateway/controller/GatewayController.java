package com.cognizant.api_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/greet")
public class GatewayController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<String> forwardGreet() {
        // Assuming greet-service is running on port 8082 with /greet endpoint
        String greetServiceUrl = "http://localhost:8082/greet";
        String response = restTemplate.getForObject(greetServiceUrl, String.class);
        return ResponseEntity.ok(response);
    }
}
