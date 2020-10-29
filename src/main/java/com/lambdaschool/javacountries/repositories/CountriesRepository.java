package com.lambdaschool.javacountries.repositories;

import com.lambdaschool.javacountries.models.Countries;
import org.springframework.data.repository.CrudRepository;

public interface CountriesRepository extends CrudRepository<Countries, Long> {

}
