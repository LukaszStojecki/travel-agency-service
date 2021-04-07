package com.example.sda.travelagencyservice.mapper;

import com.example.sda.travelagencyservice.dto.CountryDto;
import com.example.sda.travelagencyservice.model.Continent;
import com.example.sda.travelagencyservice.model.Country;
import org.springframework.stereotype.Component;


@Component
public class CountryMapper {

    public Country mapToCountry(CountryDto countryDto, Continent continent){
        if (countryDto == null){
            return null;
        } else {
            return Country.builder()
                    .name(countryDto.getName())
                    .continent(continent)
                    .build();
        }

    }

    public CountryDto mapCountryToDto(Country country){
        if (country == null){
            return null;
        } else {
            return CountryDto.builder()
                    .id(country.getId())
                    .name(country.getName())
                    .continentId(country.getContinent().getId())
                    .build();
        }


    }
}
