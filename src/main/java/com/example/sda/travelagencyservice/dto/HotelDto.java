package com.example.sda.travelagencyservice.dto;

import com.example.sda.travelagencyservice.model.City;

public class HotelDto {

    private String name;
    private String rating;
    private String description;
    private City cityId;


    public HotelDto(String name, String rating, String description, City cityId) {
        this.name = name;
        this.rating = rating;
        this.description = description;
        this.cityId = cityId;
    }

    public HotelDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }
}
