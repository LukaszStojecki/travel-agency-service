package com.example.sda.travelagencyservice.controller;

import com.example.sda.travelagencyservice.dto.UserDto;
import com.example.sda.travelagencyservice.service.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
public class TripController {

    private TripService tripService;
    private AirportService airportService;
    private CountryService countryService;
    private CityService cityService;
    private HotelService hotelService;

    public TripController(TripService tripService, AirportService airportService, CountryService countryService, CityService cityService, HotelService hotelService) {
        this.tripService = tripService;
        this.airportService = airportService;

        this.countryService = countryService;
        this.cityService = cityService;
        this.hotelService = hotelService;
    }

    @GetMapping("/promomoted")
    public String getAllPromo(Model model) {
        model.addAttribute("trips", tripService.getAllPromotedTrips());
        return "lastminute";
    }

    @GetMapping("/trip/{tripId}")
    public String showDetailsTrip(@PathVariable("tripId") Long tripId, Model model) {
        model.addAttribute("trip", tripService.getTripById(tripId));
        return "trip";
    }

    @GetMapping("/find")
    public String searchATripsByDates(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Model model) {
        model.addAttribute("search", tripService.getTripByDate(LocalDate.parse(startDate), LocalDate.parse(endDate)));
        return "index";
    }

    @GetMapping("/buyTrip/{tripId}")
    public String buyTrip(@PathVariable("tripId") Long tripId, Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("trip",tripService.findTripById(tripId) );
        return "buyTrip";
    }






}
