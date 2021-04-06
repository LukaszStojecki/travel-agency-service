package com.example.sda.travelagencyservice;

import com.example.sda.travelagencyservice.model.Role;
import com.example.sda.travelagencyservice.model.TripPurchase;
import com.example.sda.travelagencyservice.model.User;
import com.example.sda.travelagencyservice.repository.TripPurchaseRepository;
import com.example.sda.travelagencyservice.repository.TripRepository;
import com.example.sda.travelagencyservice.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class DataLoader {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private TripPurchaseRepository tripPurchaseRepository;
    private TripRepository tripRepository;


    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder,
                      TripPurchaseRepository tripPurchaseRepository, TripRepository tripRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tripPurchaseRepository = tripPurchaseRepository;
        this.tripRepository = tripRepository;
    }

    @Bean
    public InitializingBean initializingBean() {
        return () -> {
            if (userRepository.findAll().isEmpty()) {
                userRepository.save(
                        User.builder()
                                .username("admin")
                                .password(passwordEncoder.encode("admin1"))
                                .email("admin@o2.pl")
                                .roles(Role.ADMIN)
                                .build()
                );
                userRepository.save(
                        User.builder()
                                .username("user")
                                .password(passwordEncoder.encode("user1"))
                                .email("user@o2.pl")
                                .roles(Role.USER)
                                .build()
                );

            }

            if (tripPurchaseRepository.findAll().isEmpty()){
                tripPurchaseRepository.save(TripPurchase.builder()
                        .trip(tripRepository.findById(1l).orElseThrow())
                        .user(userRepository.findById(1l).orElseThrow())
                        .childQuantity(4)
                        .adultsQuantity(4)
                        .amount(2700)
                        .build()
                );
                tripPurchaseRepository.save(TripPurchase.builder()
                        .trip(tripRepository.findById(1l).orElseThrow())
                        .user(userRepository.findById(1l).orElseThrow())
                        .childQuantity(5)
                        .adultsQuantity(5)
                        .amount(3700)
                        .build()
                );
                tripPurchaseRepository.save(TripPurchase.builder()
                        .trip(tripRepository.findById(1l).orElseThrow())
                        .user(userRepository.findById(2l).orElseThrow())
                        .childQuantity(3)
                        .adultsQuantity(3)
                        .amount(2400)
                        .build()
                );
            }
        };
    }

}


