package com.example.sda.travelagencyservice.repository;

import com.example.sda.travelagencyservice.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

    boolean existsByName(String name);
    Optional<Country> findByName(String name);
}
