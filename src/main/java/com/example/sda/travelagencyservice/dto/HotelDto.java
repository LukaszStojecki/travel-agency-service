package com.example.sda.travelagencyservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelDto {

    private Long id;
    private String name;
    private String rating;
    private String description;
    private Long cityId;

}
