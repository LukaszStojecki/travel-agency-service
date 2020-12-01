package com.example.sda.travelagencyservice.model;


public enum Accomodation {
    BB("samo śniadanie"),
    HB("śniadanie i obiadokolacja"),
    FB("pełne wyżywienie"),
    AI("All inclusive"),
    OV("sam nocleg"),
    SC("wyżywienie we własnym zakresie");

    private String name;

    Accomodation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}




