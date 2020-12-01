package com.example.sda.travelagencyservice.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    private String name;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "airportFrom")
    private List<Trip> tripListFrom;
    @OneToMany(mappedBy = "airportWhere")
    private List<Trip> tripListWhere;

    public Airport() {
    }

    public Airport(String name, City city, List<Hotel> hotels, List<Trip> trips, List<Trip> tripListFrom, List<Trip> tripListWhere) {
        this.name = name;
        this.city = city;
        this.tripListFrom = tripListFrom;
        this.tripListWhere = tripListWhere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Trip> getTripListFrom() {
        return tripListFrom;
    }

    public void setTripListFrom(List<Trip> tripListFrom) {
        this.tripListFrom = tripListFrom;
    }

    public List<Trip> getTripListWhere() {
        return tripListWhere;
    }

    public void setTripListWhere(List<Trip> tripListWhere) {
        this.tripListWhere = tripListWhere;
    }



    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(id, airport.id) &&
                Objects.equals(name, airport.name) &&
                Objects.equals(city, airport.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }
}
