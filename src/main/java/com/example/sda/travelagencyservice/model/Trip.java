package com.example.sda.travelagencyservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
}
