package com.example.sda.travelagencyservice.dto;

import com.example.sda.travelagencyservice.model.Airport;
import com.example.sda.travelagencyservice.model.Country;

public class CityDto {

    private String name;
    private Country country;
    private Airport airport;


    public CityDto(String name, Country country, Airport airport) {
        this.name = name;
        this.country = country;
        this.airport = airport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
