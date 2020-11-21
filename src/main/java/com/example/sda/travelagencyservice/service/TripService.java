package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.model.Accomodation;
import com.example.sda.travelagencyservice.model.Trip;
import com.example.sda.travelagencyservice.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {

     private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips() {
       return tripRepository.findAll();
    }

    public void createTrip(Trip trip){
        trip.setArrival(trip.getArrival());
        trip.setDeparture(trip.getDeparture());
        trip.setAirport(trip.getAirport());
        trip.setAccomodation(trip.getAccomodation());
        trip.setHotel(trip.getHotel());
        trip.setAirport(trip.getAirport());
        trip.setPromoted(trip.isPromoted());
        tripRepository.save(trip);
    }
}
