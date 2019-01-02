package com.codecool.foodswap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// @SpringBootApplication is an annotation that sets up a Spring boot application. It does lots of
// things like adds all Beans to the context, sets up the routing internally etc.
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }
}