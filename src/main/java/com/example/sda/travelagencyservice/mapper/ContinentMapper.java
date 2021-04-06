package com.example.sda.travelagencyservice.mapper;

import com.example.sda.travelagencyservice.dto.ContinentDto;
import com.example.sda.travelagencyservice.model.Continent;
import org.springframework.stereotype.Component;


@Component
public class ContinentMapper {

    public Continent mapToContinent(ContinentDto continentDto){
        if (continentDto ==null){
            return null;
        } else {
            return Continent.builder()
                    .name(continentDto.getName())
                    .build();
        }


    }

    public ContinentDto mapContinentToDto(Continent continent){
        if (continent==null){
            return null;
        } else {
            return ContinentDto.builder()
                    .id(continent.getId())
                    .name(continent.getName())
                    .build();
        }


    }
}
