package com.example.sda.travelagencyservice.repository;

import com.example.sda.travelagencyservice.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City,Long> {
}
