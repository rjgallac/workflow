package com.rob.vacancyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan("com.rob.vacancyapp")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);

    }

}