package com.example.sda.travelagencyservice.model;



import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class BuyTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Trip> trip;

    @OneToOne
    private User user;

    private BigDecimal tripPrice;

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BuyTrip() {
    }

    public BuyTrip(long id, List<Trip> trip, User user, BigDecimal tripPrice) {
        this.id = id;
        this.trip = trip;
        this.user = user;
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


    public BigDecimal getTripPrice() {
        return tripPrice;
    }

    public void setTripPrice(BigDecimal tripPrice) {
        this.tripPrice = tripPrice;
    }

}
