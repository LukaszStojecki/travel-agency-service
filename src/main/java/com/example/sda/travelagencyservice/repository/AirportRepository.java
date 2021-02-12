package com.example.sda.travelagencyservice.repository;


import com.example.sda.travelagencyservice.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {

    Optional<Airport> findByName(String name);
    boolean existsByName(String name);

}
