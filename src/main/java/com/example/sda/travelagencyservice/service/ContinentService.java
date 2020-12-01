package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.model.Continent;
import com.example.sda.travelagencyservice.model.Country;
import com.example.sda.travelagencyservice.model.Trip;
import com.example.sda.travelagencyservice.repository.ContinentRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ContinentService {

    private ContinentRepository continentRepository;

    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public List<Continent> getAllContinents() {
        return continentRepository.findAll();
    }

    public Continent getContinentById(Long id) {
        return continentRepository.getOne(id);
    }


    public List<Continent> getAllContinentsSortedByName(){
        List<Continent> continents = continentRepository.findAll();
        continents.sort(Comparator.comparing(Continent::getName));
        return continents;
    }

}
