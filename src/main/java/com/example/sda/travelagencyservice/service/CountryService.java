package com.example.sda.travelagencyservice.service;

import com.example.sda.travelagencyservice.dto.CountryDto;
import com.example.sda.travelagencyservice.exception.ConflictException;
import com.example.sda.travelagencyservice.exception.NotFoundException;
import com.example.sda.travelagencyservice.mapper.CountryMapper;
import com.example.sda.travelagencyservice.model.Continent;
import com.example.sda.travelagencyservice.model.Country;
import com.example.sda.travelagencyservice.repository.ContinentRepository;
import com.example.sda.travelagencyservice.repository.CountryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class CountryService {

    private CountryRepository countryRepository;
    private CountryMapper countryMapper;
    private ContinentRepository continentRepository;

    public CountryService(CountryRepository countryRepository, CountryMapper countryMapper, ContinentRepository continentRepository) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;

        this.continentRepository = continentRepository;
    }

    public List<CountryDto> getAllCountries(){

        return countryRepository.findAll()
                .stream()
                .map(countryMapper::mapCountryToDto)
                .collect(Collectors.toList());
    }

    public void saveCountry(CountryDto countryDto) throws NotFoundException, ConflictException {
        Continent continent = continentRepository.findById(countryDto.getContinentId()).orElseThrow(()->new NotFoundException("Continent not fount" + countryDto.getContinentId().toString()));
        if (countryRepository.existsByName(countryDto.getName())){
            throw new ConflictException("Country already exists: " + countryDto.getName());
        }
        Country country = countryMapper.mapToCountry(countryDto,continent);
        countryRepository.save(country);

    }
}
