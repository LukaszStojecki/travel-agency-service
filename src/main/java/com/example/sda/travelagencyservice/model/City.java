package com.example.sda.travelagencyservice.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "cityFrom")
    private List<Trip> fromTripList;

    @OneToMany(mappedBy = "cityWhere")
    private List<Trip> whereTripList;

    @OneToMany(mappedBy = "city")
    private List<Hotel> hotelList;

    @OneToMany(mappedBy = "city")
    private  List<Airport> airports;

    public City(String name, Country country, List<Trip> fromTripList, List<Trip> whereTripList, List<Hotel> hotelList, List<Airport> airports) {
        this.name = name;
        this.country = country;
        this.fromTripList = fromTripList;
        this.whereTripList = whereTripList;
        this.hotelList = hotelList;
        this.airports = airports;
    }

    public City() {
    }

    public List<Trip> getFromTripList() {
        return fromTripList;
    }

    public void setFromTripList(List<Trip> fromTripList) {
        this.fromTripList = fromTripList;
    }

    public List<Trip> getWhereTripList() {
        return whereTripList;
    }

    public void setWhereTripList(List<Trip> whereTripList) {
        this.whereTripList = whereTripList;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
