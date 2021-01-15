package com.lambadaschool.countries.repositories;

import com.lambadaschool.countries.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountriesRepository extends CrudRepository<Country, Long> {
}
