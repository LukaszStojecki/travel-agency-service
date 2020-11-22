package com.example.sda.travelagencyservice.dto;

import com.example.sda.travelagencyservice.model.Trip;
import com.example.sda.travelagencyservice.model.User;

import java.math.BigDecimal;
import java.util.List;

public class BuyTripDto {

    private BigDecimal price;
    private User userId;
    private List<Trip> trips;

    public BuyTripDto(BigDecimal price, User userId, List<Trip> trips) {
        this.price = price;
        this.userId = userId;
        this.trips = trips;
    }

    public BuyTripDto() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
