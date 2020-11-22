package com.example.sda.travelagencyservice.dto;


public class ContinentDto {

    private String name;

    public ContinentDto(String name) {
        this.name = name;
    }

    public ContinentDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
