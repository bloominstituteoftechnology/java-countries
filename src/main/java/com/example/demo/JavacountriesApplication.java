package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavacountriesApplication {

    static CountryList list;
    public static void main(String[] args) {

        list = new CountryList();
        SpringApplication.run(JavacountriesApplication.class, args);
    }

}

