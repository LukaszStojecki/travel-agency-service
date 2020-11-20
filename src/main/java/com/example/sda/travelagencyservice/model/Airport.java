package com.example.sda.travelagencyservice.model;


import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "airport")
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "airport")
    private List<Trip> trips;


    public Airport() {
    }

    public Airport(Long id, String name, City city, List<Hotel> hotels, List<Trip> trips) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.hotels = hotels;
        this.trips = trips;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<Hotel> getHotels() {
        return hotels;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
