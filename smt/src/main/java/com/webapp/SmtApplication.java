package com.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.webapp")
public class SmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmtApplication.class, args);
    }

}
