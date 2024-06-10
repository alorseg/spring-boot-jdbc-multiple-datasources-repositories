package com.example.multisourcerepositoryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.multisourcerepositoryapp")
public class MultisourceRepositoryAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultisourceRepositoryAppApplication.class, args);
    }

}
