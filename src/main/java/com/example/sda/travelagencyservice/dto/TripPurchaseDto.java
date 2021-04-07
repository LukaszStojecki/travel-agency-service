package com.example.sda.travelagencyservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripPurchaseDto {

    private Long id;
    private String tripPurchase;
    private String userPurchase;
    private Integer adultsQuantity;
    private Integer childrenQuantity;
    private double amount;

}
