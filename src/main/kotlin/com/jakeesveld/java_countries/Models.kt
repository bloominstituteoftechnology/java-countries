package com.jakeesveld.java_countries

class Country(val name: String,val population: Long, val landMass: Long, val medianAge: Long){
    override fun toString(): String {
        return "Country(name='$name', population=$population, landMass=$landMass, medianAge=$medianAge)"
    }
}

