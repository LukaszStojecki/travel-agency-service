package com.example.sda.travelagencyservice.mapper;

import com.example.sda.travelagencyservice.dto.ContinentDto;
import com.example.sda.travelagencyservice.model.Continent;
import org.springframework.stereotype.Component;


@Component
public class ContinentMapper {

    public Continent mapToContinent(ContinentDto continentDto){
        return Continent.builder()
                .name(continentDto.getName())
                .build();

    }

    public ContinentDto mapContinentToDto(Continent continent){

        return ContinentDto.builder()
                .id(continent.getId())
                .name(continent.getName())
                .build();
    }
}
