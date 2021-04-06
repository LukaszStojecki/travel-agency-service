package com.example.sda.travelagencyservice.service;

import com.example.sda.travelagencyservice.dto.TripPurchaseDto;
import com.example.sda.travelagencyservice.dto.UserDto;
import com.example.sda.travelagencyservice.exception.NotFoundException;
import com.example.sda.travelagencyservice.exception.PlaceAvailable;
import com.example.sda.travelagencyservice.mapper.TripMapper;
import com.example.sda.travelagencyservice.mapper.TripPurchaseMapper;
import com.example.sda.travelagencyservice.model.Trip;
import com.example.sda.travelagencyservice.model.TripPurchase;
import com.example.sda.travelagencyservice.model.User;
import com.example.sda.travelagencyservice.repository.TripPurchaseRepository;
import com.example.sda.travelagencyservice.repository.TripRepository;
import com.example.sda.travelagencyservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripPurchaseService {

    private TripPurchaseRepository tripPurchaseRepository;
    private TripPurchaseMapper tripPurchaseMapper;
    private TripRepository tripRepository;
    private TripService tripService;
    private UserRepository userRepository;
    private UserService userService;
    private TripMapper tripMapper;

    public TripPurchaseService(TripPurchaseRepository tripPurchaseRepository, TripPurchaseMapper tripPurchaseMapper,
                               TripRepository tripRepository, TripService tripService, UserRepository userRepository,
                               UserService userService, TripMapper tripMapper) {
        this.tripPurchaseRepository = tripPurchaseRepository;
        this.tripPurchaseMapper = tripPurchaseMapper;
        this.tripRepository = tripRepository;
        this.tripService = tripService;
        this.userRepository = userRepository;
        this.userService = userService;
        this.tripMapper = tripMapper;
    }


    public List<TripPurchaseDto> getAllPurchaseTrip() {
        return tripPurchaseRepository.findAll().stream()
                .map(tripPurchase -> tripPurchaseMapper.mapPurchaseToDto(tripPurchase))
                .collect(Collectors.toList());
    }

    public List<TripPurchaseDto> getAllPurchaseTripByUser(User user){
        return tripPurchaseRepository.findByUser(user).stream()
                .map(tripPurchase -> tripPurchaseMapper.mapPurchaseToDto(tripPurchase))
                .collect(Collectors.toList());
    }

    public TripPurchaseDto findById(Long id) throws NotFoundException {
        return tripPurchaseRepository.findById(id)
                .map(tripPurchase -> tripPurchaseMapper.mapPurchaseToDto(tripPurchase))
                .orElseThrow(() -> new NotFoundException("TripPurchase of id " + id + ", doesn't exist"));
    }


    @Transactional
    public TripPurchaseDto buyTrip(Long id, TripPurchaseDto tripPurchaseDto, Principal principal) throws NotFoundException, PlaceAvailable {
        Trip trip = tripRepository.findById(id).orElseThrow(() -> new NotFoundException("Trip not found"));
        User user = userRepository.findByEmail(principal.getName()).orElseThrow(()->new UsernameNotFoundException("User not found"));
        tripService.checkPlaceAvailable(trip, tripPurchaseDto.getAdultsQuantity(), tripPurchaseDto.getChildrenQuantity());
        trip.setAdultPlaceAvailable(trip.getAdultPlaceAvailable() - tripPurchaseDto.getAdultsQuantity());
        trip.setChildPlaceAvailable(trip.getChildPlaceAvailable() - tripPurchaseDto.getChildrenQuantity());

        TripPurchase tripPurchaseSave = tripPurchaseMapper.mapToTripPurchase(tripPurchaseDto, trip, user);
        return tripPurchaseMapper.mapPurchaseToDto(tripPurchaseRepository.save(tripPurchaseSave));
    }


    @Transactional
    public Double calculateTrip(Long id) throws NotFoundException {
        TripPurchase tripPurchase = tripPurchaseRepository.findById(id).orElseThrow(() -> new NotFoundException("TripPurchase of id " + id + ", doesn't exist"));
        Integer childQuantity = tripPurchase.getChildQuantity();
        Double childPrice = tripPurchase.getTrip().getChildPrice();
        Integer adultsQuantity = tripPurchase.getAdultsQuantity();
        Double adultPrice = tripPurchase.getTrip().getAdultPrice();
        double total = (childQuantity * childPrice) + (adultsQuantity * adultPrice);
        tripPurchase.setAmount(total);
        return total;
    }
}

