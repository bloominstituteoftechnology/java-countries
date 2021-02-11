package com.lambdaschool.countryapp.repositories;

import com.lambdaschool.countryapp.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepo extends CrudRepository<Country, Long> {
}
