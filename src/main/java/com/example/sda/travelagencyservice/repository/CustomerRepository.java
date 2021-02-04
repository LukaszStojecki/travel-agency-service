package com.example.sda.travelagencyservice.repository;

import com.example.sda.travelagencyservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
