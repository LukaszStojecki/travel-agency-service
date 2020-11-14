package com.example.sda.travelagencyservice.model;


import javax.persistence.*;
import java.util.List;


@Entity
//@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "id_country")
    private long id;

    @ManyToOne
   // @JoinColumn(name = "id_continent")
    private Continent continent;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    public Country() {
    }

    public Country(long id, Continent continent, List<City> cities) {
        this.id = id;
        this.continent = continent;
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
