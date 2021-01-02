package com.example.sda.travelagencyservice.dto;

import com.example.sda.travelagencyservice.model.Trip;
import com.example.sda.travelagencyservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuyTripDto {

    private Long id;
    private BigDecimal price;
    private User userId;
    private List<Trip> trips;

}
