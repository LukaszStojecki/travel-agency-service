package com.example.sda.travelagencyservice.dto;

import com.example.sda.travelagencyservice.model.City;
import com.example.sda.travelagencyservice.model.Country;

public class AirportDto {

    private String name;
    private City cityId;

    public AirportDto() {
    }

    public AirportDto(String name, City cityId) {
        this.name = name;
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }
}
