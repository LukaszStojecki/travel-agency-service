package com.example.sda.travelagencyservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Country country;
    @OneToMany(mappedBy = "departureCity")
    private List<Trip> fromTripList;
    @OneToMany(mappedBy = "arrivalCity")
    private List<Trip> whereTripList;
    @OneToMany(mappedBy = "city")
    private List<Hotel> hotelList;
    @OneToMany(mappedBy = "city")
    private  List<Airport> airports;

}
