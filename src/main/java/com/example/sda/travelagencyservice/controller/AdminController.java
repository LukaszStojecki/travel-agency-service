package com.example.sda.travelagencyservice.controller;


import com.example.sda.travelagencyservice.dto.AirportDto;
import com.example.sda.travelagencyservice.dto.CityDto;
import com.example.sda.travelagencyservice.dto.HotelDto;
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
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


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

//    @GetMapping("/admin/panel")
//    public String readAllTrips(Model model) {
//        List<Trip> trips = tripService.getAllTrips();
//        model.addAttribute("trips", trips);
//        return "/admin/panel";
//    }

    @GetMapping("/panel")
    public String getPanel( Trip trip,Model model) {
        model.addAttribute("addTrip", new Trip());
        return "/panel";
    }
    @GetMapping("/panel/add")
    public String showTrip( Trip trip,Model model) {
        List<Airport> airports = airportService.getAllAirports();
        List<City> cities = cityService.getAllCities();
        List<Hotel> hotels = hotelService.getAllHotels();
        model.addAttribute("addTrip", new TripDto());
        model.addAttribute("airportsList",airports);
        model.addAttribute("citiesList",cities);
        model.addAttribute("hotelsList",hotels);
        return "/addTrip";
    }

    @PostMapping("/panel/add")
    public String addNewTrip(@ModelAttribute("addTrip") TripDto tripDto, Model model) {
        model.addAttribute("addTrip", tripDto);
        tripService.createTrip(tripDto);
        return "redirect:/panel";
    }

    @GetMapping("/panel/add/airport")
    public String showAddAirportForm(Model model) {
        //List<City> cityList = cityService.getAllCities();
        //model.addAttribute("cities",cityList);
        model.addAttribute("addAirport", new Airport());
        return "addAirport";
    }

    @PostMapping("/panel/add/airport")
    public String addNewAirport(@ModelAttribute(name = "addAirport") AirportDto airportDto, Model model) {
        model.addAttribute("addAirport", airportDto);
        airportService.addAirports(airportDto);
        return "redirect:/panel";
    }

    @GetMapping("/panel/add/city")
    public String showAddCityForm(Model model) {
        //List<City> cityList = cityService.getAllCities();
        //model.addAttribute("cities",cityList);
        model.addAttribute("addCity", new City());
        return "addCity";
    }

    @PostMapping("/panel/add/city")
    public String addNewCity(@ModelAttribute(name = "addCity") CityDto cityDto, Model model) {
        model.addAttribute("addCity", cityDto);
        cityService.addNewCity(cityDto);
        return "redirect:/panel";
    }

    @GetMapping("/panel/add/hotel")
    public String showAddHotelForm(Model model) {
        //List<City> cityList = cityService.getAllCities();
        //model.addAttribute("cities",cityList);
        model.addAttribute("addHotel", new Hotel());
        return "addHotel";
    }

    @PostMapping("/panel/add/hotel")
    public String addNewHotel(@ModelAttribute(name = "addHotel") HotelDto hotelDto, Model model) {
        model.addAttribute("addHotel", hotelDto);
        hotelService.addNewHotel(hotelDto);
        return "redirect:/panel";
    }


}
