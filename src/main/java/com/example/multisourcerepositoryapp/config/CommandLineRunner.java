package com.example.multisourcerepositoryapp.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

public class CommandLineRunner {
    @Bean
    public org.springframework.boot.CommandLineRunner printBeans(ApplicationContext context) {
        return args -> {
            Map<String, Object> beans = context.getBeansWithAnnotation(Bean.class);
            beans.forEach((beanName, bean) -> System.out.println(beanName + ": " + bean.getClass().getName()));
        };
    }
}
