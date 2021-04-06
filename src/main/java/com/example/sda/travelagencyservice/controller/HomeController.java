package com.example.sda.travelagencyservice.controller;

import com.example.sda.travelagencyservice.dto.ContinentDto;
import com.example.sda.travelagencyservice.dto.CountryDto;
import com.example.sda.travelagencyservice.dto.TripDto;
import com.example.sda.travelagencyservice.dto.TripPurchaseDto;
import com.example.sda.travelagencyservice.service.ContinentService;
import com.example.sda.travelagencyservice.service.CountryService;
import com.example.sda.travelagencyservice.service.TripPurchaseService;
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
    private TripPurchaseService tripPurchaseService;

    public HomeController(TripService tripService, ContinentService continentService, CountryService countryService, TripPurchaseService tripPurchaseService) {
        this.tripService = tripService;
        this.continentService = continentService;
        this.countryService = countryService;
        this.tripPurchaseService = tripPurchaseService;
    }

    @GetMapping()
    public String home(Model model) {
        List<ContinentDto> continentDtos = continentService.getAllContinents();
        List<CountryDto> countryDtos = countryService.getAllCountries();
        List<TripDto> promoted = tripService.getAllPromotedTrips();
        List<TripDto> lastMinuteTrips = tripService.getLastMinuteTrips();
        List<TripDto> allTrip = tripService.getAllTrip();
        List<TripPurchaseDto> allPurchase = tripPurchaseService.getAllPurchaseTrip().subList(0,3);
        model.addAttribute("promotedTrips",promoted);
        model.addAttribute("allTrip",allTrip);
        model.addAttribute("lastminute",lastMinuteTrips);
        model.addAttribute("continents",continentDtos);
        model.addAttribute("countries",countryDtos);
        model.addAttribute("allPurchase",allPurchase);
        return "index";
    }
}
