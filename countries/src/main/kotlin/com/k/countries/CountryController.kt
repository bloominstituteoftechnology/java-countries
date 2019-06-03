package com.k.countries


import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.util.ArrayList

@RestController
class CountryController {

    // return the names of all the countries alphabetically
    @RequestMapping(value = ["/names/all"],
            produces = ["application/json"])
    fun getCountries_name(): ArrayList<String> {
        val countries_name = ArrayList<String>()
        countries_name.ensureCapacity(CountriesRepo.countryList.size)
        for (country in CountriesRepo.countryList) {
            countries_name.add(country.name)
        }

        return countries_name
    }

    // return the countries alphabetically that begin with the given letter
    @RequestMapping("/names/begin")
    fun getCountriesBeginWith(@RequestParam(value="letter") letter: String): ArrayList<Country> {
        val countries = ArrayList<Country>()
        if (letter.length != 1 || !isAlpha(letter)) {
            return countries
        }

        for (country in CountriesRepo.countryList) {
            // ignore case
            if (Character.toLowerCase(country.name[0])
                    == Character.toLowerCase(letter[0])) {
                countries.add(country)
            }
        }

        countries.sortBy { it.name }

        return countries
    }

    // return the countries alphabetically that have a name equal to or longer than the given length
    @RequestMapping("/names/size")
    fun getCountriesSizeLetters(@RequestParam("letters") letters: Int): ArrayList<Country> {
        if (letters < 1) {
            return CountriesRepo.countryList
        }

        val countries = ArrayList<Country>()
        for (country in CountriesRepo.countryList) {
            if (country.name.length >= letters) {
                countries.add(country)
            }
        }

        countries.sortBy { it.name }

        return countries
    }

    // return the country with the smallest population
    @RequestMapping("/population/min")
    fun getCountryWithMinPop(): Country? {
        if (CountriesRepo.countryList.size == 0) {
            return null
        }

        var countryWithMinPop = CountriesRepo.countryList[0]

        var i = 1
        while (i < CountriesRepo.countryList.size) {
            val country = CountriesRepo.countryList[i]
            if (country.population < countryWithMinPop.population) {
                countryWithMinPop = country
            }

            ++i
        }

        return countryWithMinPop
    }

    // return the country with the largest population
    @RequestMapping("/population/max")
    fun getCountryWithMaxPop(): Country? {
        if (CountriesRepo.countryList.size == 0) {
            return null
        }

        var countryWithMaxPop = CountriesRepo.countryList[0]

        var i = 1
        while (i < CountriesRepo.countryList.size) {
            val country = CountriesRepo.countryList[i]
            if (country.population > countryWithMaxPop.population) {
                countryWithMaxPop = country
            }

            ++i
        }

        return countryWithMaxPop
    }

    // return the countries that have a median age equal to or greater than the given age
    @RequestMapping("/age/age")
    fun getCountriesByMedianAge(@RequestParam("age") age: Int): ArrayList<Country> {
        val countries = ArrayList<Country>()
        for (country in CountriesRepo.countryList) {
            if (country.medianAge >= age) {
                countries.add(country)
            }
        }

        return countries
    }

    // return the country with the smallest median age
    @RequestMapping("/age/min")
    fun getCountryWithMinMedianAge(): Country? {
        if (CountriesRepo.countryList.size == 0) {
            return null
        }

        var countryWithMinMedianAge = CountriesRepo.countryList[0]
        var i = 1
        while (i < CountriesRepo.countryList.size) {
            val country = CountriesRepo.countryList[i]
            if (country.medianAge < countryWithMinMedianAge.medianAge) {
                countryWithMinMedianAge = country
            }

            ++i
        }

        return countryWithMinMedianAge
    }

    // return the country the the greatest median age
    @RequestMapping("/age/max")
    fun getCountryWithMaxMedianAge(): Country? {
        if (CountriesRepo.countryList.size == 0) {
            return null
        }

        var countryWithMaxMedianAge = CountriesRepo.countryList[0]
        var i = 1
        while (i < CountriesRepo.countryList.size) {
            val country = CountriesRepo.countryList[i]
            if (country.medianAge > countryWithMaxMedianAge.medianAge) {
                countryWithMaxMedianAge = country
            }

            ++i
        }

        return countryWithMaxMedianAge;
    }

    companion object {
        fun isAlpha(name: String): Boolean {
            return name.matches("[a-zA-Z]+".toRegex())
        }

    }



}