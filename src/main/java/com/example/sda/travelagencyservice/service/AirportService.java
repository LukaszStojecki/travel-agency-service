package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.AirportDto;
import com.example.sda.travelagencyservice.model.Airport;
import com.example.sda.travelagencyservice.repository.AirportRepository;
import com.example.sda.travelagencyservice.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    private AirportRepository airportRepository;
    private CityService cityService;


    public AirportService(AirportRepository airportRepository, CityService cityService) {
        this.airportRepository = airportRepository;
        this.cityService = cityService;
    }

    public List<Airport> getAllAirports(){
        return airportRepository.findAll();
    }

    public Airport findAirportById(Long airportId) {
        return airportRepository.getOne(airportId);
    }

    public Airport addAirports(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setId(airportDto.getId());
        airport.setName(airportDto.getName());
        airport.setCity(cityService.findCityById(airportDto.getCityId()));
        return airportRepository.save(airport);
    }

    public Airport findByName(String name) {
        return airportRepository.findAirportByName(name);
    }

}
