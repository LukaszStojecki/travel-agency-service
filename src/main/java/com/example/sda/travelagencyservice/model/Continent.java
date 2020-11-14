package com.example.sda.travelagencyservice.model;


import javax.persistence.*;
import java.util.List;


@Entity
//@Table(name = "continent")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_continent")
    private long id;

    private String name;

    @OneToMany(mappedBy = "continent")
    private List<Country> countries;

    public Continent() {
    }

    public Continent(long id, String name, List<Country> countries) {
        this.id = id;
        this.name = name;
        this.countries = countries;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
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
}
