package com.ampersand.countries;

public class Country
{
    private String name;
    private int population;
    private int landMassSize;
    private int medianAge;

    public Country(String name, int population, int landMassSize, int medianAge)
    {
        this.name = name;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public int getLandMassSize()
    {
        return landMassSize;
    }

    public void setLandMassSize(int landMassSize)
    {
        this.landMassSize = landMassSize;
    }

    public int getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(int medianAge)
    {
        this.medianAge = medianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", landMassSize=" + landMassSize +
                ", medianAge=" + medianAge +
                '}';
    }
}
