package com.example.sda.travelagencyservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AirportDto {

    private Long id;
    private String name;
    private Long cityId;

}
