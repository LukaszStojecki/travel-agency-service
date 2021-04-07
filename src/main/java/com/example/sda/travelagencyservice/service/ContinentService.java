package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.ContinentDto;
import com.example.sda.travelagencyservice.exception.ConflictException;
import com.example.sda.travelagencyservice.mapper.ContinentMapper;
import com.example.sda.travelagencyservice.model.Continent;
import com.example.sda.travelagencyservice.repository.ContinentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContinentService {

    private ContinentRepository continentRepository;
    private ContinentMapper continentMapper;

    public ContinentService(ContinentRepository continentRepository, ContinentMapper continentMapper) {
        this.continentRepository = continentRepository;
        this.continentMapper = continentMapper;
    }

    public List<ContinentDto> getAllContinents(){
        return continentRepository.findAll().stream()
                .map(continent ->continentMapper.mapContinentToDto(continent))
                .collect(Collectors.toList());
    }


    public void saveContinent(ContinentDto continentDto) throws Exception {
        if (continentRepository.existsByName(continentDto.getName())){
            throw new ConflictException("Continent already exists: " + continentDto.getName());
        }
        Continent continent = continentMapper.mapToContinent(continentDto);
        continentRepository.save(continent);
    }
}
