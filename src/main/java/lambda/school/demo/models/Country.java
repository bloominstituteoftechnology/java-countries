package lambda.school.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long countryid;
    private String name;
    private long population;
    private long landmasskn2;
    private int medianage;

    public Country()
    {
    }

    public Country(
        String name,
        long population,
        long landmasskn2,
        int medianage)
    {
        this.name = name;
        this.population = population;
        this.landmasskn2 = landmasskn2;
        this.medianage = medianage;
    }

    public long getCountryid()
    {
        return countryid;
    }

    public void setCountryid(long countryid)
    {
        this.countryid = countryid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    public long getLandmasskn2()
    {
        return landmasskn2;
    }

    public void setLandmasskn2(long landmasskn2)
    {
        this.landmasskn2 = landmasskn2;
    }

    public int getMedianage()
    {
        return medianage;
    }

    public void setMedianage(int medianage)
    {
        this.medianage = medianage;
    }
}
