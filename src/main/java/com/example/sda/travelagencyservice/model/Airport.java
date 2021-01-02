package com.example.sda.travelagencyservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "airportFrom")
    private List<Trip> tripListFrom;
    @OneToMany(mappedBy = "airportWhere")
    private List<Trip> tripListWhere;
}
