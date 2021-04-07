package com.example.sda.travelagencyservice.repository;

import com.example.sda.travelagencyservice.dto.UserDto;
import com.example.sda.travelagencyservice.model.TripPurchase;
import com.example.sda.travelagencyservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripPurchaseRepository extends JpaRepository<TripPurchase,Long> {
    List<TripPurchase> findByUser(User user);
}
