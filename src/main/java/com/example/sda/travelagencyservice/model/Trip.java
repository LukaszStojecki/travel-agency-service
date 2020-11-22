package com.example.sda.travelagencyservice.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    private List<City> cityFrom;

    @ManyToMany
    private List<City> cityWhere;

    @ManyToMany
    private List<Airport> airportFrom;

    @ManyToMany
    private List<Airport> airportWhere;

    @ManyToMany
    private List<Hotel> hotelWhere;

    private LocalDate arrival;

    private LocalDate departure;

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

    public List<City> getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(List<City> cityFrom) {
        this.cityFrom = cityFrom;
    }

    public List<City> getCityWhere() {
        return cityWhere;
    }

    public void setCityWhere(List<City> cityWhere) {
        this.cityWhere = cityWhere;
    }

    public List<Airport> getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(List<Airport> airportFrom) {
        this.airportFrom = airportFrom;
    }

    public List<Airport> getAirportWhere() {
        return airportWhere;
    }

    public void setAirportWhere(List<Airport> airportWhere) {
        this.airportWhere = airportWhere;
    }

    public List<Hotel> getHotelWhere() {
        return hotelWhere;
    }

    public void setHotelWhere(List<Hotel> hotelWhere) {
        this.hotelWhere = hotelWhere;
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
