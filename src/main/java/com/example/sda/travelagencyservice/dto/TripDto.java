package com.example.sda.travelagencyservice.dto;


import com.example.sda.travelagencyservice.model.Airport;
import com.example.sda.travelagencyservice.model.City;
import com.example.sda.travelagencyservice.model.Hotel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TripDto {

    private Long tripId;
    private City cityFrom;
    private City cityWhere;
    private Airport airportFrom;
    private Airport airportWhere;
    private Hotel hotelWhere;
    private String arrival;
    private String departure;
    private Integer days;
    private String accomodation;
    private BigDecimal adultPrice;
    private BigDecimal childPrice;
    private boolean isPromoted;
    private Integer adultPlaceAvailable;
    private Integer childPlaceAvailable;

    public TripDto(Long tripId, City cityFrom, City cityWhere, Airport airportFrom, Airport airportWhere, Hotel hotelWhere, String arrival, String departure, Integer days, String accomodation, BigDecimal adultPrice, BigDecimal childPrice, boolean isPromoted, Integer adultPlaceAvailable, Integer childPlaceAvailable) {
        this.tripId = tripId;
        this.cityFrom = cityFrom;
        this.cityWhere = cityWhere;
        this.airportFrom = airportFrom;
        this.airportWhere = airportWhere;
        this.hotelWhere = hotelWhere;
        this.arrival = arrival;
        this.departure = departure;
        this.days = days;
        this.accomodation = accomodation;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.isPromoted = isPromoted;
        this.adultPlaceAvailable = adultPlaceAvailable;
        this.childPlaceAvailable = childPlaceAvailable;
    }

    public TripDto() {
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityWhere() {
        return cityWhere;
    }

    public void setCityWhere(City cityWhere) {
        this.cityWhere = cityWhere;
    }

    public Airport getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(Airport airportFrom) {
        this.airportFrom = airportFrom;
    }

    public Airport getAirportWhere() {
        return airportWhere;
    }

    public void setAirportWhere(Airport airportWhere) {
        this.airportWhere = airportWhere;
    }

    public Hotel getHotelWhere() {
        return hotelWhere;
    }

    public void setHotelWhereId(Hotel hotelWhere) {
        this.hotelWhere = hotelWhere;
    }

    public String getArrivalDate() {
        return arrival;
    }

    public void setArrivalDate(String arrival) {
        this.arrival = arrival;
    }

    public String getDepartureDate() {
        return departure;
    }

    public void setDepartureDate(String departure) {
        this.departure = departure;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(String accomodation) {
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
