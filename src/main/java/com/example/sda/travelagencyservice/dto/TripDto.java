package com.example.sda.travelagencyservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TripDto {

    private Long id;
    private String cityFrom;
    private String cityWhere;
    private String airportFrom;
    private String airportWhere;
    private String hotelWhere;
    private String startDate;
    private String endDate;
    private Integer days;
    private String accomodation;
    private BigDecimal adultPrice;
    private BigDecimal childPrice;
    private boolean isPromoted;
    private Integer adultPlaceAvailable;
    private Integer childPlaceAvailable;

}

