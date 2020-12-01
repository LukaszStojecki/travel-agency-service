package com.example.sda.travelagencyservice.service;

import com.example.sda.travelagencyservice.dto.CityDto;
import com.example.sda.travelagencyservice.model.City;
import com.example.sda.travelagencyservice.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private CityRepository cityRepository;
    private CountryService countryService;

    public CityService(CityRepository cityRepository, CountryService countryService) {
        this.cityRepository = cityRepository;

        this.countryService = countryService;
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public City addNewCity(CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        city.setCountry(countryService.getCountryById(cityDto.getCountryId()));
        return cityRepository.save(city);
    }

    public City findCityById(Long id) {
        return cityRepository.getOne(id);
    }
    public City findCityName(String name) {
        return cityRepository.findCityByName(name);
    }
}
