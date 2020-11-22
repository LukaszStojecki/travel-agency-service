package com.example.sda.travelagencyservice.service;

import com.example.sda.travelagencyservice.dto.CityDto;
import com.example.sda.travelagencyservice.model.City;
import com.example.sda.travelagencyservice.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public void addNewCity(CityDto cityDto) {
        City city = new City();
        city.setName(cityDto.getName());
        city.setCountry(cityDto.getCountry());
        city.setAirports(Arrays.asList(cityDto.getAirport()));
        cityRepository.save(city);
    }
}
