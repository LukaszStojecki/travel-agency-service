package com.example.sda.travelagencyservice.controller;

import com.example.sda.travelagencyservice.dto.TripDto;
import com.example.sda.travelagencyservice.model.Continent;
import com.example.sda.travelagencyservice.model.Country;
import com.example.sda.travelagencyservice.model.Trip;
import com.example.sda.travelagencyservice.service.ContinentService;
import com.example.sda.travelagencyservice.service.CountryService;
import com.example.sda.travelagencyservice.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;


@Controller
public class HomeController {

    private TripService tripService;
    private CountryService countryService;
    private ContinentService continentService;

    public HomeController(TripService tripService, CountryService countryService, ContinentService continentService) {
        this.tripService = tripService;
        this.countryService = countryService;
        this.continentService = continentService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Trip> trips = tripService.getAllTrips();
        List<Trip> promoted = tripService.getAllPromotedTrips();
        List<Continent> continents = continentService.getAllContinentsSortedByName();
        List<Country> countries = countryService.getAllCountriesByName();
//        List<Trip> tripList = tripService.getTripByDate(startDate,endDate);
        model.addAttribute("triplist",trips);
        model.addAttribute("promotedTrips",promoted);
        model.addAttribute("continents",continents);
        model.addAttribute("countries",countries);
        model.addAttribute("lastminute",tripService.getAllLastMinuteTrip());
//        model.addAttribute("search",tripList);
        return "index";
    }
}
