package lambda.school.demo.repositories;

import lambda.school.demo.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long>
{
}
