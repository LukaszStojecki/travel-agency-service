package com.example.sda.travelagencyservice.dto;


import java.util.Objects;

public class AirportDto {

    private Long id;


    private String name;
    private Long cityId;

    public AirportDto() {
    }

    public AirportDto(Long id, String name, Long cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "AirportDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cityId=" + cityId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportDto that = (AirportDto) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                cityId.equals(that.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cityId);
    }
}
