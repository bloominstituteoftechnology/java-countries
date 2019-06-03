package com.jakeesveld.java_countries

import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/country")
class CountryController{

    @RequestMapping(value = "/names/all")
    fun getAllNames(): ResponseEntity<Any>{
        countryList.countryList.sortBy { country -> country.name }
        return ResponseEntity(countryList.countryList, HttpStatus.OK)
    }


}