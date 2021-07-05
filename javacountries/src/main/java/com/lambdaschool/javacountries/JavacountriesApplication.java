package com.lambdaschool.javacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavacountriesApplication
{
    //add static field of type CountriesL
    static CountriesL theCountriesL;

    public static void main(String[] args) {
        //instantiate the static field (i.e the object):
        theCountriesL = new CountriesL();

        SpringApplication.run(JavacountriesApplication.class, args);

    }



}
