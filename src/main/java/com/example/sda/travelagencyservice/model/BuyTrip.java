package com.example.sda.travelagencyservice.model;



import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
//@Table(name = "buytrip")
public class BuyTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_buyTrip")
    private long id;

    @OneToMany(mappedBy = "buyTrip")
    private List<Trip> trip;

    public BuyTrip() {
    }

    public BuyTrip(long id, List<Trip> trip, Integer person, BigDecimal tripPrice) {
        this.id = id;
        this.trip = trip;
        this.person = person;
        this.tripPrice = tripPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Trip> getTrip() {
        return trip;
    }

    public void setTrip(List<Trip> trip) {
        this.trip = trip;
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    public BigDecimal getTripPrice() {
        return tripPrice;
    }

    public void setTripPrice(BigDecimal tripPrice) {
        this.tripPrice = tripPrice;
    }

    private Integer person;

    private BigDecimal tripPrice;
}
