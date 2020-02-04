package com.example.helloservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
    @Value("${greeting.default}")
    private String greeting;

    @GetMapping("/greeting")
    public String greeting() {
        return greeting + new Date();
    }
}
