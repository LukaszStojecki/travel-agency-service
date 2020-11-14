package com.example.sda.travelagencyservice.repository;


import com.example.sda.travelagencyservice.model.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport,Long> {

}
