package com.example.helloservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class HelloController {
    @Value("${greeting.default}")
    private String greeting;

    @GetMapping("/greeting")
    public String greeting() {
        String str = greeting + new Date();
        log.info(str);
        return str;
    }
}
