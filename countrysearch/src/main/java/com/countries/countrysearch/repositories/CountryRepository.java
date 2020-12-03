package com.countries.countrysearch.repositories;

import com.countries.countrysearch.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long>
{

}
