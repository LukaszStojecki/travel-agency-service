package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.AirportDto;
import com.example.sda.travelagencyservice.exception.ConflictException;
import com.example.sda.travelagencyservice.exception.NotFoundException;
import com.example.sda.travelagencyservice.mapper.AirportMapper;
import com.example.sda.travelagencyservice.model.Airport;
import com.example.sda.travelagencyservice.model.City;
import com.example.sda.travelagencyservice.repository.AirportRepository;
import com.example.sda.travelagencyservice.repository.CityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

    private AirportRepository airportRepository;
    private CityRepository cityRepository;
    private AirportMapper airportMapper;


    public AirportService(AirportRepository airportRepository, CityService cityService, CityRepository cityRepository, AirportMapper airportMapper) {
        this.airportRepository = airportRepository;
        this.cityRepository = cityRepository;
        this.airportMapper = airportMapper;
    }

    public List<AirportDto> getAllAirports(){
        return airportRepository.findAll().stream()
                .map(airport -> airportMapper.mapAirportEntityToDto(airport))
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveAirport(AirportDto airportDTO) throws ConflictException, NotFoundException {
        City city = cityRepository.findById(airportDTO.getCityId()).orElseThrow(()-> new NotFoundException("City not found" + airportDTO.getCityId().toString()));
        if (airportRepository.existsByName(airportDTO.getName())){
            throw new ConflictException("Airport already exists: " + airportDTO.getName());
        }
        Airport airport = airportMapper.mapToAirport(airportDTO, city);
        airportRepository.save(airport);
    }
}
