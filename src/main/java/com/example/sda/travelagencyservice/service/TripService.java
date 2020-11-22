package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.TripDto;
import com.example.sda.travelagencyservice.model.*;
import com.example.sda.travelagencyservice.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public void createTrip(TripDto tripDto){
        Trip trip = new Trip();
        trip.setCityFrom(Collections.singletonList(tripDto.getCityFrom()));
        trip.setAirportFrom(Collections.singletonList(tripDto.getAirportFrom()));
        trip.setCityWhere(Collections.singletonList(tripDto.getCityWhere()));
        trip.setAirportWhere(Collections.singletonList(tripDto.getAirportWhere()));
        trip.setHotelWhere(Collections.singletonList(tripDto.getHotelWhere()));
        trip.setArrival(LocalDate.parse(tripDto.getArrivalDate()));
        trip.setDeparture(LocalDate.parse(tripDto.getDepartureDate()));
        trip.setDays(tripDto.getDays());
        trip.setAccomodation(Accomodation.valueOf(tripDto.getAccomodation()));
        trip.setAdultPrice(tripDto.getAdultPrice());
        trip.setChildPrice(tripDto.getChildPrice());
        trip.setPromoted(tripDto.isPromoted());
        trip.setAdultPlaceAvailable(tripDto.getAdultPlaceAvailable());
        trip.setChildPlaceAvailable(tripDto.getChildPlaceAvailable());
        tripRepository.save(trip);
    }
}
