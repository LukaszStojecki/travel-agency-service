package com.example.sda.travelagencyservice.repository;

import com.example.sda.travelagencyservice.model.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {

    boolean existsByName(String name);

    Optional<Continent> findByName(String name);
}
