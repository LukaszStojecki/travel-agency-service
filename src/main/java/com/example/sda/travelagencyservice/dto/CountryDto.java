package com.example.sda.travelagencyservice.dto;

import com.example.sda.travelagencyservice.model.Continent;

public class CountryDto {

    private String name;
    private Continent continent;


    public CountryDto() {

    }

    public CountryDto(String name, Continent continent) {
        this.name = name;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
