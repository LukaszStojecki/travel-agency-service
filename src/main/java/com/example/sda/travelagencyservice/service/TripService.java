package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.TripDto;
import com.example.sda.travelagencyservice.model.*;
import com.example.sda.travelagencyservice.repository.TripRepository;
import com.example.sda.travelagencyservice.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripService {

    private TripRepository tripRepository;
    private CityService cityService;
    private AirportService airportService;
    private HotelService hotelService;
    private UserRepository userRepository;

    public TripService(TripRepository tripRepository, CityService cityService, AirportService airportService, HotelService hotelService, UserRepository userRepository) {
        this.tripRepository = tripRepository;
        this.cityService = cityService;
        this.airportService = airportService;
        this.hotelService = hotelService;
        this.userRepository = userRepository;
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public List<Trip> getAllLastMinuteTrip() {
        return tripRepository.findAll().stream()
                .filter(trip -> trip.getStartDate().isAfter(ChronoLocalDate.from(LocalDateTime.now())))
                .sorted(Comparator.comparing(Trip::getStartDate))
                .collect(Collectors.toList());
    }

    public List<Trip> getAllPromotedTrips() {
        return tripRepository.findAll().stream()
                .filter(Trip::isPromoted)
                .collect(Collectors.toList());
    }

    public Trip getTripById(Long id) {
        return tripRepository.getOne(id);
    }

    public Optional<Trip> findTripById(Long tripId) {
        return tripRepository.findById(tripId);
    }


    public List<Trip> getTripByDate(LocalDate startDate, LocalDate endDate) {
        List<Trip> tripList = tripRepository.findTripByStartDateAndEndDate(startDate, endDate);
        return tripList;
    }

    public Trip mapDtoToEntity(TripDto tripDto) {

        Trip trip = new Trip();
        trip.setId(tripDto.getId());
        trip.setCityFrom(cityService.findCityById(tripDto.getCityFrom()));
        trip.setAirportFrom(airportService.findAirportById(tripDto.getAirportFrom()));
        trip.setCityWhere(cityService.findCityById(tripDto.getCityWhere()));
        trip.setAirportWhere(airportService.findAirportById(tripDto.getAirportWhere()));
        trip.setHotelWhere(hotelService.findById(tripDto.getHotelWhere()));
        trip.setStartDate(LocalDate.parse(tripDto.getStartDate()));
        trip.setEndDate(LocalDate.parse(tripDto.getEndDate()));
        trip.setDays(tripDto.getDays());
        trip.setAccomodation(Accomodation.valueOf(tripDto.getAccomodation()));
        trip.setAdultPrice(tripDto.getAdultPrice());
        trip.setChildPrice(tripDto.getChildPrice());
        trip.setPromoted(tripDto.isPromoted());
        trip.setAdultPlaceAvailable(tripDto.getAdultPlaceAvailable());
        trip.setChildPlaceAvailable(tripDto.getChildPlaceAvailable());
        return tripRepository.save(trip);
    }

    public TripDto mapTripToDto(Trip trip) {
        TripDto tripDto = new TripDto();
        tripDto.setId(trip.getId());
        tripDto.setCityFrom(trip.getCityFrom().getId());
        tripDto.setAirportFrom(trip.getAirportFrom().getId());
        tripDto.setCityWhere(trip.getCityWhere().getId());
        tripDto.setAirportWhere(trip.getAirportWhere().getId());
        tripDto.setHotelWhere(trip.getHotelWhere().getId());
        tripDto.setStartDate(String.valueOf(trip.getStartDate()));
        tripDto.setEndDate(String.valueOf(trip.getEndDate()));
        tripDto.setDays(trip.getDays());
        tripDto.setAccomodation(String.valueOf(trip.getAccomodation()));
        tripDto.setAdultPrice(trip.getAdultPrice());
        tripDto.setChildPrice(trip.getChildPrice());
        tripDto.setPromoted(trip.isPromoted());
        tripDto.setAdultPlaceAvailable(trip.getAdultPlaceAvailable());
        tripDto.setChildPlaceAvailable(trip.getChildPlaceAvailable());
        return tripDto;
    }
}

