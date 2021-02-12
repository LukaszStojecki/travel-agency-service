package com.example.sda.travelagencyservice.service;

import com.example.sda.travelagencyservice.dto.CityDto;
import com.example.sda.travelagencyservice.exception.ConflictException;
import com.example.sda.travelagencyservice.exception.NotFoundException;
import com.example.sda.travelagencyservice.mapper.CityMapper;
import com.example.sda.travelagencyservice.model.City;
import com.example.sda.travelagencyservice.model.Country;
import com.example.sda.travelagencyservice.repository.CityRepository;
import com.example.sda.travelagencyservice.repository.CountryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository  cityRepository;
    private final CityMapper cityMapper;
    private final CountryRepository countryRepository;

    public CityService(CityRepository cityRepository, CityMapper cityMapper, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
        this.countryRepository = countryRepository;
    }

    public List<CityDto> getAllCities(){
        return cityRepository.findAll()
                .stream()
                .map(cityMapper::mapCityEntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveCity(CityDto cityDto) throws ConflictException, NotFoundException {
        Country country = countryRepository.findById(cityDto.getCountryId()).orElseThrow(()-> new NotFoundException("Country not found" + cityDto.getCountryId().toString()));
        if (cityRepository.existsByName(cityDto.getName())){
            throw new ConflictException("City already exists: " + cityDto.getName());
        }
        City city = cityMapper.mapToCity(cityDto, country);
        cityRepository.save(city);
    }

    @Transactional
    public CityDto updateCity(Long id, CityDto cityDto) throws NotFoundException {

        City city = cityRepository.findById(id).orElseThrow(()->new NotFoundException("City Not found"));
        city.setName(cityDto.getName());
        City cityUpdated = cityRepository.save(city);
        return cityMapper.mapCityEntityToDto(cityUpdated);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

//    public City findCityById(Long id) {
//        return cityRepository.getOne(id);
//    }
//    public City findCityName(String name) {
//        return cityRepository.findCityByName(name);
//    }
}
