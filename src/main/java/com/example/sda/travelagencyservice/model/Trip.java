package com.example.sda.travelagencyservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrival;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departure;

    private Integer days;

    @Enumerated(EnumType.STRING)
    private Accomodation accomodation;

    private BigDecimal adultPrice;

    private BigDecimal childPrice;

    private boolean isPromoted;

    private Integer adultPlaceAvailable;

    private Integer childPlaceAvailable;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Airport airport;


    public Trip(long id, LocalDate arrival, LocalDate departure, Integer days, Accomodation accomodation, BigDecimal adultPrice, BigDecimal childPrice, boolean isPromoted, Integer adultPlaceAvailable, Integer childPlaceAvailable, Hotel hotel, Airport airport) {
        this.id = id;
        this.arrival = arrival;
        this.departure = departure;
        this.days = days;
        this.accomodation = accomodation;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.isPromoted = isPromoted;
        this.adultPlaceAvailable = adultPlaceAvailable;
        this.childPlaceAvailable = childPlaceAvailable;
        this.hotel = hotel;
        this.airport = airport;
    }

    public Trip() {
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Accomodation getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = accomodation;
    }

    public BigDecimal getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(BigDecimal adultPrice) {
        this.adultPrice = adultPrice;
    }

    public BigDecimal getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(BigDecimal childPrice) {
        this.childPrice = childPrice;
    }

    public boolean isPromoted() {
        return isPromoted;
    }

    public void setPromoted(boolean promoted) {
        isPromoted = promoted;
    }

    public Integer getAdultPlaceAvailable() {
        return adultPlaceAvailable;
    }

    public void setAdultPlaceAvailable(Integer adultPlaceAvailable) {
        this.adultPlaceAvailable = adultPlaceAvailable;
    }

    public Integer getChildPlaceAvailable() {
        return childPlaceAvailable;
    }

    public void setChildPlaceAvailable(Integer childPlaceAvailable) {
        this.childPlaceAvailable = childPlaceAvailable;
    }
}
