package com.example.sda.travelagencyservice.service;

import com.example.sda.travelagencyservice.dto.CountryDto;
import com.example.sda.travelagencyservice.model.Country;
import com.example.sda.travelagencyservice.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CountryService {

    private CountryRepository countryRepository;
    private ContinentService continentService;

    public CountryService(CountryRepository countryRepository, ContinentService continentService) {
        this.countryRepository = countryRepository;
        this.continentService = continentService;
    }

    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

    public Country getCountryById(Long id) {
        return countryRepository.getOne(id);
    }

    public Country addCountries(CountryDto countryDto) {
        Country country = new Country();
        country.setId(countryDto.getId());
        country.setName(countryDto.getName());
        country.setContinent(continentService.getContinentById(countryDto.getContinentId()));
        return countryRepository.save(country);
    }

    public List<Country> getAllCountriesByName() {
        List<Country> countries = countryRepository.findAll();
        countries.sort(Comparator.comparing(Country::getName));
        return countries;
    }
}
