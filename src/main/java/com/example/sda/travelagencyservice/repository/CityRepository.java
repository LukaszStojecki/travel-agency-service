package com.example.sda.travelagencyservice.repository;

import com.example.sda.travelagencyservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

//    City findCityByName(String name);
    boolean existsByName(String name);
    Optional<City> findByName(String name);
}

