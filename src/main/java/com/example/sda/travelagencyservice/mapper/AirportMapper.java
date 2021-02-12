package com.example.sda.travelagencyservice.mapper;


import com.example.sda.travelagencyservice.dto.AirportDto;
import com.example.sda.travelagencyservice.model.Airport;
import com.example.sda.travelagencyservice.model.City;
import org.springframework.stereotype.Component;

@Component
public class AirportMapper {

    public Airport mapToAirport(AirportDto airportDTO, City city){
        return Airport.builder()
                .name(airportDTO.getName())
                .city(city)
                .build();
    }

    public AirportDto mapAirportEntityToDto(Airport airport){
        return AirportDto.builder()
                .id(airport.getId())
                .name(airport.getName())
                .cityId(airport.getCity().getId())
                .build();
    }
}
