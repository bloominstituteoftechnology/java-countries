package localhost.elisaalvarez.countries.repositories;

import localhost.elisaalvarez.countries.country.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryReprository extends CrudRepository<Country, Long>
{

}
