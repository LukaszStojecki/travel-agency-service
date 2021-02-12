package com.example.sda.travelagencyservice.repository;

import com.example.sda.travelagencyservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    Optional<Hotel> findByName(String name);
    boolean existsByName(String name);
}
