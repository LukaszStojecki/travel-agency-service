package com.example.sda.travelagencyservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private City departureCity;
    @ManyToOne
    private City arrivalCity;
    @ManyToOne
    private Airport departureAirport;
    @ManyToOne
    private Airport arrivalAirport;
    @OneToOne
    private Hotel hotel;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;
    private Integer days;
    @Enumerated(EnumType.STRING)
    private Accomodation accomodation;
    private Double adultPrice;
    private Double childPrice;
    private boolean isPromoted;
    private Integer adultPlaceAvailable;
    private Integer childPlaceAvailable;
}
