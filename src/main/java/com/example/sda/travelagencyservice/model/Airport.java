package com.example.sda.travelagencyservice.model;



import javax.persistence.*;
import java.util.List;

@Entity(name = "airport")
public class Airport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "airport")
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "airport")
    private List<Trip> trips;

    public List<Hotel> getHotels() {
        return hotels;
    }

    public Airport() {
    }


    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
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
