package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.AirportDto;
import com.example.sda.travelagencyservice.model.Airport;
import com.example.sda.travelagencyservice.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    private AirportRepository airportRepository;


    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports(){
        return airportRepository.findAll();
    }

    public void addAirports(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setName(airportDto.getName());
        airport.setCity(airportDto.getCityId());
        airportRepository.save(airport);
    }

}
