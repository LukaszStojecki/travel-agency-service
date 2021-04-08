package com.example.sda.travelagencyservice;

import com.example.sda.travelagencyservice.model.*;
import com.example.sda.travelagencyservice.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;


@Configuration
public class DataLoader {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private TripPurchaseRepository tripPurchaseRepository;
    private TripRepository tripRepository;
    private CityRepository cityRepository;
    private AirportRepository airportRepository;
    private HotelRepository hotelRepository;
    private CountryRepository countryRepository;
    private ContinentRepository continentRepository;

    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder,
                      TripPurchaseRepository tripPurchaseRepository, TripRepository tripRepository,
                      CityRepository cityRepository, AirportRepository airportRepository,
                      HotelRepository hotelRepository, CountryRepository countryRepository,
                      ContinentRepository continentRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tripPurchaseRepository = tripPurchaseRepository;
        this.tripRepository = tripRepository;
        this.cityRepository = cityRepository;
        this.airportRepository = airportRepository;
        this.hotelRepository = hotelRepository;
        this.countryRepository = countryRepository;
        this.continentRepository = continentRepository;
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

            if (continentRepository.findAll().isEmpty()){
                continentRepository.save(Continent.builder()
                        .name("Europa")
                        .build());
                continentRepository.save(Continent.builder()
                        .name("Azja")
                        .build());
            }
            if (countryRepository.findAll().isEmpty()){
                countryRepository.save(Country.builder()
                        .name("Polska")
                        .continent(continentRepository.findByName("Europa").orElseThrow())
                        .build());
                countryRepository.save(Country.builder()
                        .name("Chiny")
                        .continent(continentRepository.findByName("Azja").orElseThrow())
                        .build());
                countryRepository.save(Country.builder()
                        .name("Niemcy")
                        .continent(continentRepository.findByName("Europa").orElseThrow())
                        .build());
            }
            if (cityRepository.findAll().isEmpty()){
                cityRepository.save(City.builder()
                        .name("Poznań")
                        .country(countryRepository.findByName("Polska").orElseThrow())
                        .build());
                cityRepository.save(City.builder()
                        .name("Berlin")
                        .country(countryRepository.findByName("Niemcy").orElseThrow())
                        .build());
                cityRepository.save(City.builder()
                        .name("Pekin")
                        .country(countryRepository.findByName("Chiny").orElseThrow())
                        .build());
            }
            if (hotelRepository.findAll().isEmpty()){
                hotelRepository.save(Hotel.builder()
                        .name("Mercure")
                        .description("Fajny hotel")
                        .city(cityRepository.findByName("Poznań").orElseThrow())
                        .rating("5")
                        .build());
                hotelRepository.save(Hotel.builder()
                        .name("Sheraton")
                        .description("Ekskluzywny hotel")
                        .city(cityRepository.findByName("Berlin").orElseThrow())
                        .rating("5")
                        .build());
                hotelRepository.save(Hotel.builder()
                        .name("Mandarin")
                        .description("Super hotel")
                        .city(cityRepository.findByName("Pekin").orElseThrow())
                        .rating("4")
                        .build());
            }
            if (airportRepository.findAll().isEmpty()){
                airportRepository.save(Airport.builder()
                        .name("Ławica")
                        .city(cityRepository.findByName("Poznań").orElseThrow())
                        .build());
                airportRepository.save(Airport.builder()
                        .name("Tempelhof")
                        .city(cityRepository.findByName("Berlin").orElseThrow())
                        .build());
                airportRepository.save(Airport.builder()
                        .name("Daxing")
                        .city(cityRepository.findByName("Pekin").orElseThrow())
                        .build());
            }
            if (tripRepository.findAll().isEmpty()){
                tripRepository.save(Trip.builder()
                        .id(1L)
                        .departureCity(cityRepository.findByName("Poznań").orElseThrow())
                        .departureAirport(airportRepository.findByName("Ławica").orElseThrow())
                        .arrivalCity(cityRepository.findByName("Pekin").orElseThrow())
                        .arrivalAirport(airportRepository.findByName("Daxing").orElseThrow())
                        .hotel(hotelRepository.findByName("Mandarin").orElseThrow())
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusDays(4))
                        .days(4)
                        .accomodation(Accomodation.valueOf("BB"))
                        .isPromoted(true)
                        .adultPlaceAvailable(50)
                        .childPlaceAvailable(25)
                        .adultPrice(1200.00)
                        .childPrice(400.00)
                        .build());
            }
            if (tripPurchaseRepository.findAll().isEmpty()){
                tripPurchaseRepository.save(TripPurchase.builder()
                        .trip(tripRepository.findById(1L).orElseThrow())
                        .user(userRepository.findById(1L).orElseThrow())
                        .childQuantity(4)
                        .adultsQuantity(4)
                        .amount(2700)
                        .build()
                );
                tripPurchaseRepository.save(TripPurchase.builder()
                        .trip(tripRepository.findById(1L).orElseThrow())
                        .user(userRepository.findById(1L).orElseThrow())
                        .childQuantity(5)
                        .adultsQuantity(5)
                        .amount(3700)
                        .build()
                );
                tripPurchaseRepository.save(TripPurchase.builder()
                        .trip(tripRepository.findById(1L).orElseThrow())
                        .user(userRepository.findById(2L).orElseThrow())
                        .childQuantity(3)
                        .adultsQuantity(3)
                        .amount(2400)
                        .build()
                );
            }
        };
    }

}

