package com.example.helloservice;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@Slf4j
public class HelloController {
    @Value("${greeting.default}")
    private String greeting;

    @Value("${aservice.url}")
    private String serviceUrl;

    @Autowired
    private RestTemplate rest;

    @GetMapping("/greeting")
    public String greeting() {
        String response = rest.getForObject(this.serviceUrl + "/actuator/health", String.class);

        String str = greeting + new Date() + " " + response;
        log.info(str);
        return str;
    }
}
