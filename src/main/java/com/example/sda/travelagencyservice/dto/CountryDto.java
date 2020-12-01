package com.example.sda.travelagencyservice.dto;

import java.util.Objects;


public class CountryDto {


    private Long id;
    private String name;
    private Long continentId;


    public CountryDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CountryDto(String name, Long continentId) {
        this.name = name;
        this.continentId = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getContinentId() {
        return continentId;
    }

    public void setContinentId(Long continentId) {
        this.continentId = continentId;
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "idCountry=" + id +
                ", name='" + name + '\'' +
                ", continentId=" + continentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto that = (CountryDto) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                continentId.equals(that.continentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, continentId);
    }
}
