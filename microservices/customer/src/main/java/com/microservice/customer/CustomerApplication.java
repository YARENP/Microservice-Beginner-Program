package com.microservice.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// this is the main page of spring boot application, so i will annotate it as springboot application
@SpringBootApplication
public class CustomerApplication {
    public static void main(String[] args) {
        // spring application runs this class first with the arg of main method
        SpringApplication.run(CustomerApplication.class, args);
    }
}
