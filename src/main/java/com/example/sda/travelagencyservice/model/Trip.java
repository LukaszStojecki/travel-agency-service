package com.example.sda.travelagencyservice.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
//@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_trip")
    private long id;

    private LocalDateTime arrival;

    private LocalDateTime departure;

    private Integer days;

    @Enumerated(EnumType.STRING)
    private Accomodation accomodation;

    private BigDecimal adultPrice;

    private BigDecimal childPrice;

    private boolean isPromoted;

    private Integer adultPlaceAvailable;

    private Integer childPlaceAvailable;

    public Trip(long id, LocalDateTime arrival, LocalDateTime departure, Integer days, Accomodation accomodation, BigDecimal adultPrice, BigDecimal childPrice, boolean isPromoted, Integer adultPlaceAvailable, Integer childPlaceAvailable, Hotel hotel, Airport airport, BuyTrip buyTrip) {
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
        this.buyTrip = buyTrip;
    }

    @ManyToOne
    //@JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @ManyToOne
    //@JoinColumn(name = "id_airport")
    private Airport airport;

    @ManyToOne
    //@JoinColumn(name = "id_buyTrip")
    private BuyTrip buyTrip;

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

    public BuyTrip getBuyTrip() {
        return buyTrip;
    }

    public void setBuyTrip(BuyTrip buyTrip) {
        this.buyTrip = buyTrip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
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
