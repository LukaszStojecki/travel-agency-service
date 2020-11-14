package com.example.sda.travelagencyservice.repository;

import com.example.sda.travelagencyservice.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country,Long> {
}
