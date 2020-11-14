package com.example.sda.travelagencyservice.model;

import javax.persistence.*;
import java.util.List;


@Entity
//@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_hotel")
    private long id;
    private String name;
    private String rating;
    private String description;

    public Hotel(long id, String name, String rating, String description, City city, Airport airport, List<Trip> trips) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.description = description;
        this.city = city;
        this.airport = airport;
        this.trips = trips;
    }

    @ManyToOne
    //@JoinColumn(name = "id_city")
    private City city;

    @ManyToOne
    //@JoinColumn(name = "id_airport")
    private Airport airport;

    @OneToMany(mappedBy = "hotel")
    private List<Trip> trips;

    public Hotel() {
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
