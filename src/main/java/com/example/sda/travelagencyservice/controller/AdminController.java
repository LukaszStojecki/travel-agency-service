package com.example.sda.travelagencyservice.controller;


import com.example.sda.travelagencyservice.dto.AirportDto;
import com.example.sda.travelagencyservice.dto.CityDto;
import com.example.sda.travelagencyservice.dto.HotelDto;
import com.example.sda.travelagencyservice.dto.TripDto;
import com.example.sda.travelagencyservice.exception.BadRequestException;
import com.example.sda.travelagencyservice.exception.NotFoundException;
import com.example.sda.travelagencyservice.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;



@Controller
public class AdminController {

    private TripService tripService;
    private AirportService airportService;
    private CityService cityService;
    private HotelService hotelService;
    private UserService userService;

    public AdminController(TripService tripService, AirportService airportService,
                           CityService cityService, HotelService hotelService, UserService userService) {
        this.tripService = tripService;
        this.airportService = airportService;
        this.cityService = cityService;
        this.hotelService = hotelService;
        this.userService = userService;
    }


    @GetMapping("/panel")
    public String getPanel(Model model) {
        List<TripDto> allTrips = tripService.getAllTrip();
        model.addAttribute("allTrip", allTrips);
        return "panel";
    }

    @GetMapping("/panel/add")
    public String showTrip(Model model) {
        List<AirportDto> airports = airportService.getAllAirports();
        List<CityDto> cities = cityService.getAllCities();
        List<HotelDto> hotels = hotelService.getAllHotel();
        model.addAttribute("addTrip", new TripDto());
        model.addAttribute("airportsList", airports);
        model.addAttribute("citiesList", cities);
        model.addAttribute("hotelsList", hotels);
        return "addTrip";
    }

    @PostMapping("/panel/add")
    public String createTrip(@ModelAttribute("addTrip") TripDto tripDto) throws BadRequestException {
        System.out.println("Dane: " + tripDto);
        tripService.saveTrip(tripDto);
        return "redirect:/panel";
    }

    @GetMapping("/panel/edit/{id}")
    public String updateTrip(@PathVariable("id") Long id, Model model) throws NotFoundException {
        TripDto trip = tripService.findById(id);
        System.out.println("before: " + trip);
        List<CityDto> cities = cityService.getAllCities();
        List<AirportDto> airports = airportService.getAllAirports();
        List<HotelDto> hotels = hotelService.getAllHotel();
        model.addAttribute("cities", cities);
        model.addAttribute("trip", trip);
        model.addAttribute("airports",airports);
        model.addAttribute("hotels",hotels);
        return "editTrip";
    }

    @PostMapping("/panel/edit/{id}")
    public String updateTrip(@PathVariable(name = "id") Long id, @ModelAttribute("trip") TripDto tripDto) throws NotFoundException, BadRequestException {
        tripService.updateTrip(id, tripDto);
        System.out.println("after: " + tripDto);
        return "redirect:/panel";
    }

    @GetMapping("/panel/delete/{id}")
    public String deleteTripById(@PathVariable Long id) {
        tripService.deleteById(id);
        return "redirect:/panel";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "usersList";
    }

}
