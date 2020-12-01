package com.example.sda.travelagencyservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private City cityFrom;

    @ManyToOne
    private City cityWhere;

    @ManyToOne
    private Airport airportFrom;

    @ManyToOne
    private Airport airportWhere;

    @OneToOne
    private Hotel hotelWhere;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer days;

    @Enumerated(EnumType.STRING)
    private Accomodation accomodation;

    private BigDecimal adultPrice;

    private BigDecimal childPrice;

    private boolean isPromoted;

    private Integer adultPlaceAvailable;

    private Integer childPlaceAvailable;


    public Trip() {
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

    public void setHotelWhere(Hotel hotelWhere) {
        this.hotelWhere = hotelWhere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", cityFrom=" + cityFrom +
                ", cityWhere=" + cityWhere +
                ", airportFrom=" + airportFrom +
                ", airportWhere=" + airportWhere +
                ", hotelWhere=" + hotelWhere +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", days=" + days +
                ", accomodation=" + accomodation +
                ", adultPrice=" + adultPrice +
                ", childPrice=" + childPrice +
                ", isPromoted=" + isPromoted +
                ", adultPlaceAvailable=" + adultPlaceAvailable +
                ", childPlaceAvailable=" + childPlaceAvailable +
                '}';
    }
}
