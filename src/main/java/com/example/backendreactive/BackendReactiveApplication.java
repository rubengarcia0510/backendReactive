package com.example.backendreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class BackendReactiveApplication {

    public static void main(String[] args) {

        SpringApplication.run(BackendReactiveApplication.class, args);


    }

}
