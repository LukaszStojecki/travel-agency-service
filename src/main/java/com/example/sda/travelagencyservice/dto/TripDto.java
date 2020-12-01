package com.example.sda.travelagencyservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TripDto {

    private Long id;
    private Long cityFrom;
    private Long cityWhere;
    private Long airportFrom;
    private Long airportWhere;
    private Long hotelWhere;
    private String startDate;
    private String endDate;
    private Integer days;
    private String accomodation;
    private BigDecimal adultPrice;
    private BigDecimal childPrice;
    private boolean isPromoted;
    private Integer adultPlaceAvailable;
    private Integer childPlaceAvailable;


    public TripDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(Long cityFrom) {
        this.cityFrom = cityFrom;
    }

    public Long getCityWhere() {
        return cityWhere;
    }

    public void setCityWhere(Long cityWhere) {
        this.cityWhere = cityWhere;
    }

    public Long getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(Long airportFrom) {
        this.airportFrom = airportFrom;
    }

    public Long getAirportWhere() {
        return airportWhere;
    }

    public void setAirportWhere(Long airportWhere) {
        this.airportWhere = airportWhere;
    }

    public Long getHotelWhere() {
        return hotelWhere;
    }

    public void setHotelWhere(Long hotelWhere) {
        this.hotelWhere = hotelWhere;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    @Override
    public String toString() {
        return "TripDto{" +
                "id=" + id +
                ", cityFrom=" + cityFrom +
                ", cityWhere=" + cityWhere +
                ", airportFrom=" + airportFrom +
                ", airportWhere=" + airportWhere +
                ", hotelWhere=" + hotelWhere +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", days=" + days +
                ", accomodation='" + accomodation + '\'' +
                ", adultPrice=" + adultPrice +
                ", childPrice=" + childPrice +
                ", isPromoted=" + isPromoted +
                ", adultPlaceAvailable=" + adultPlaceAvailable +
                ", childPlaceAvailable=" + childPlaceAvailable +
                '}';
    }
}

