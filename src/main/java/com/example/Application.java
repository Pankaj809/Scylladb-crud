package com.example;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {

//        System.out.println("Database Connected");
        Micronaut.run(Application.class, args);
    }
}