package com.lambdaschool.com.countries.repositories;

import com.lambdaschool.com.countries.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Country, Long>
{
}
