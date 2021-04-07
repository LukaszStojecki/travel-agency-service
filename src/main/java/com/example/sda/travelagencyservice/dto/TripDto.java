package com.example.sda.travelagencyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {

    private Long id;
    private String departureCity;
    private String arrivalCity;
    private String departureAirport;
    private String arrivalAirport;
    private String hotel;
    private String startDate;
    private String endDate;
    private Integer days;
    private String accomodation;
    private Double adultPrice;
    private Double childPrice;
    private boolean isPromoted;
    private Integer adultPlaceAvailable;
    private Integer childPlaceAvailable;

}

