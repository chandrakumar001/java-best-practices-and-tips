package com.example.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaBestPracticesAndTips {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(
                JavaBestPracticesAndTips.class,
                args
        );
    }
}