package com.example.sda.travelagencyservice.repository;

import com.example.sda.travelagencyservice.dto.AirportDto;
import com.example.sda.travelagencyservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

    City findCityByName(String name);
}

