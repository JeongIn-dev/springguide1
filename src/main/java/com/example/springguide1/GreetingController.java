package com.example.springguide1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/quote")
    public Quote quote() {
        Quote quote = new Quote();
        quote.setType("success");
        Value value = new Value();
        value.setId(10L);
        value.setQuote("Really loving Spring Boot, makes stand alone Spring apps easy.");
        quote.setValue(value);
        quote.setStatus("OK");

        return quote;
    }
}