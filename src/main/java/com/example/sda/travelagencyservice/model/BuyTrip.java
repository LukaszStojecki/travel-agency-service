package com.example.sda.travelagencyservice.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "buytrip")
public class BuyTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "buytrip")
    private List<Trip> trip;

    private String person;

    private BigDecimal tripPrice;
}
