package com.example.sda.travelagencyservice.controller;

import com.example.sda.travelagencyservice.dto.ContinentDto;
import com.example.sda.travelagencyservice.dto.CountryDto;
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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {


    private TripService tripService;
    private ContinentService continentService;
    private CountryService countryService;

    public HomeController(TripService tripService, ContinentService continentService, CountryService countryService) {
        this.tripService = tripService;
        this.continentService = continentService;
        this.countryService = countryService;
    }

    @GetMapping()
    public String home(Model model) {
        List<ContinentDto> continentDtos = continentService.getAllContinents();
        List<CountryDto> countryDtos = countryService.getAllCountries();
        List<TripDto> promoted = tripService.getAllPromotedTrips();
        List<TripDto> lastMinuteTrips = tripService.getLastMinuteTrips();
        List<TripDto> allTrip = tripService.getAllTrip();
        model.addAttribute("promotedTrips",promoted);
        model.addAttribute("allTrip",allTrip);
        model.addAttribute("lastminute",lastMinuteTrips);
        model.addAttribute("continents",continentDtos);
        model.addAttribute("countries",countryDtos);
        return "index";
    }
}
