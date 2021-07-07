package com.jakeesveld.java_countries

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JavaCountriesApplication

public var countryList: CountryList = CountryList()

fun main(args: Array<String>) {
    runApplication<JavaCountriesApplication>(*args)
}
