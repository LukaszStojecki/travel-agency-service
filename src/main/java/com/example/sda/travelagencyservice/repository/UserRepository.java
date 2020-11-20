package com.example.sda.travelagencyservice.repository;


import com.example.sda.travelagencyservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);

}
