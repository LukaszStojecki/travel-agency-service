package com.example.sda.travelagencyservice.dto;

import com.example.sda.travelagencyservice.model.Trip;
import com.example.sda.travelagencyservice.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class BuyTripDto {

    private Long id;
    private BigDecimal price;
    private User userId;
    private List<Trip> trips;

    public BuyTripDto(Long id, BigDecimal price, User userId, List<Trip> trips) {
        this.id = id;
        this.price = price;
        this.userId = userId;
        this.trips = trips;
    }

    public BuyTripDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
