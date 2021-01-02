package com.example.sda.travelagencyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryDto {

    private Long id;
    private String name;
    private Long continentId;

}
