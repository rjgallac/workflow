package com.rob.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@CrossOrigin(maxAge = 3600)
@Configuration
public class WorkflowAppFront {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WorkflowAppFront.class, args);
    }
}
