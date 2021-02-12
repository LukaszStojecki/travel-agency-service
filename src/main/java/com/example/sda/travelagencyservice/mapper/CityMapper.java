package com.example.sda.travelagencyservice.mapper;


import com.example.sda.travelagencyservice.dto.CityDto;
import com.example.sda.travelagencyservice.model.City;
import com.example.sda.travelagencyservice.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public City mapToCity(CityDto cityDto, Country country){
        return City.builder()
                .name(cityDto.getName())
                .country(country)
                .build();
    }

    public CityDto mapCityEntityToDto(City city){

        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .countryId(city.getCountry().getId())
                .build();

    }
}
