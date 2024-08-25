package com.rep.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rep.app")
public class RepApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepApplication.class, args);
    }

}