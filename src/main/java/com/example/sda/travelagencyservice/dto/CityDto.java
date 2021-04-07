package com.example.sda.travelagencyservice.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CityDto {

    private Long id;
    private String name;
    private Long countryId;

}

