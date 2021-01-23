package com.example.sda.travelagencyservice.controller;


import com.example.sda.travelagencyservice.dto.TripDto;
import com.example.sda.travelagencyservice.model.Airport;
import com.example.sda.travelagencyservice.model.City;
import com.example.sda.travelagencyservice.model.Hotel;
import com.example.sda.travelagencyservice.model.Trip;

import com.example.sda.travelagencyservice.service.AirportService;
import com.example.sda.travelagencyservice.service.CityService;
import com.example.sda.travelagencyservice.service.HotelService;
import com.example.sda.travelagencyservice.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class AdminController {

    private TripService tripService;
    private AirportService airportService;
    private CityService cityService;
    private HotelService hotelService;

    public AdminController(TripService tripService, AirportService airportService, CityService cityService, HotelService hotelService) {
        this.tripService = tripService;
        this.airportService = airportService;
        this.cityService = cityService;
        this.hotelService = hotelService;
    }


    @GetMapping("/panel")
    public String getPanel(Model model) {
        List<Trip> allTrips = tripService.getAllTrips();
        model.addAttribute("allTrip", allTrips);
        return "panel";
    }

    @GetMapping("/panel/add")
    public String showTrip(Model model) {
        List<Airport> airports = airportService.getAllAirports();
        List<City> cities = cityService.getAllCities();
        List<Hotel> hotels = hotelService.getAllHotels();
        model.addAttribute("addTrip", new TripDto());
        model.addAttribute("airportsList", airports);
        model.addAttribute("citiesList", cities);
        model.addAttribute("hotelsList", hotels);
        return "addTrip";
    }

    @PostMapping("/panel/add")
    public String addNewTrip(@ModelAttribute("addTrip") TripDto tripDto) {
        tripService.mapDtoToEntity(tripDto);
        return "redirect:/panel";
    }

    @GetMapping("/panel/edit/{id}")
    public String editTripById(@PathVariable("id") Long id, Model model) {
        Trip trip = tripService.findTripById(id).get();
        if (tripService.findTripById(id).isPresent()){
            model.addAttribute("editTrip", tripService.mapTripToDto(trip));
            model.addAttribute("cities", cityService.getAllCities());
            model.addAttribute("airports", airportService.getAllAirports());
            model.addAttribute("hotels", hotelService.getAllHotels());
            return "editTrip";
        }
        return "redirect:/panel/add";
    }

    @PostMapping("/panel/edit/{id}")
    public String editTripPost(@PathVariable("id") Long id, TripDto tripDto) {
//        tripDto.setId(id);
        Trip trip = tripService.mapDtoToEntity(tripDto);
        trip.setId(id);
        tripService.addNewTrip(trip);
        return "redirect:/trip/{id}";
    }

}
