package com.example.sda.travelagencyservice.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String rating;
    private String description;

    @ManyToOne
    private City city;

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

    @ManyToOne
    private Airport airport;

    @OneToMany(mappedBy = "hotel")
    private List<Trip> trips;

    public long getId() {
        return id;
    }

    public Hotel() {
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
