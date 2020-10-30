package com.lambdaschool.com.countries.repositories;

import com.lambdaschool.com.countries.models.CountryInfo;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<CountryInfo, Long>
{
}
