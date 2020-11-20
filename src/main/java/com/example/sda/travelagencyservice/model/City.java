package com.example.sda.travelagencyservice.model;



import javax.persistence.*;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "city")
    private  List<Airport> airports;

    public City() {
    }

    public City(Long id, Country country, List<Hotel> hotels, List<Airport> airports) {
        this.id = id;
        this.country = country;
        this.hotels = hotels;
        this.airports = airports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

}
