package com.example.sda.travelagencyservice.repository;


import com.example.sda.travelagencyservice.model.BuyTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyTripRepository extends JpaRepository<BuyTrip,Long> {
}
