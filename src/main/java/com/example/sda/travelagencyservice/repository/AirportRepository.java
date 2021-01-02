package com.example.sda.travelagencyservice.repository;


import com.example.sda.travelagencyservice.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {

    Airport findAirportByName(String name);
}
