package lambda.school.countries.repositories;

import lambda.school.countries.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository <Country,Long> {
}
