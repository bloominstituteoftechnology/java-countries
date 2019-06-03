package com.jakeesveld.java_countries

import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/country"])
class CountryController{

    @RequestMapping(value = ["/names/all"])
    fun getAllNames(): ResponseEntity<Any>{
        countryList.countryList.sortBy { country -> country.name }
        return ResponseEntity(countryList.countryList, HttpStatus.OK)
    }

    @RequestMapping(value = ["/names/start/{letter}"])
    fun getNamesByFirstLetter(@PathVariable letter: Char): ResponseEntity<Any>{
        return ResponseEntity(countryList.countryList.filter
        { country -> country.name.get(0) == letter }.sortedBy
        { country -> country.name }, HttpStatus.OK)
    }


    @RequestMapping(value = ["/names/size/{number}"])
    fun getNamesBySize(@PathVariable number: Long): ResponseEntity<Any>{
        return ResponseEntity(countryList.countryList.filter {
            country -> country.name.length >= number }.sortedBy
        {country -> country.name
        }, HttpStatus.OK)
    }

    @RequestMapping(value = ["/population/size/{people}"])
    fun getCountryByPopulation(@PathVariable people: Long): ResponseEntity<Any>{
        return ResponseEntity(countryList.countryList.filter {
            country -> country.population >= people }.sortedBy {
            country -> country.population
        }, HttpStatus.OK)
    }


    /*/population/size/{people}

return the countries that have a population equal to or greater than the given population*/
}