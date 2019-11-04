package local.tylerb.javacountries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private long id;
    private String name;
    private long population;
    private long size;
    private long age;

    private static final AtomicLong counter = new AtomicLong();

    public Country(String name, long population, long size, long age) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.size = size;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
