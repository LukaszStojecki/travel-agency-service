package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.model.Customer;
import com.example.sda.travelagencyservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer addNewCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }
}
