package com.example.sda.travelagencyservice.dto;


import java.util.Objects;

public class HotelDto {

    private Long id;
    private String name;
    private String rating;
    private String description;
    private Long cityId;


    public HotelDto(Long id, String name, String rating, String description, Long cityId) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.description = description;
        this.cityId = cityId;
    }

    public HotelDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "HotelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                ", cityId=" + cityId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelDto hotelDto = (HotelDto) o;
        return id.equals(hotelDto.id) &&
                name.equals(hotelDto.name) &&
                rating.equals(hotelDto.rating) &&
                description.equals(hotelDto.description) &&
                cityId.equals(hotelDto.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rating, description, cityId);
    }
}
