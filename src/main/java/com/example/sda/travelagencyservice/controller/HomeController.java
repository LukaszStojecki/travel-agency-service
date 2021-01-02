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

import java.util.List;


@Controller
public class HomeController {

    private TripService tripService;

    public HomeController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Trip> trips = tripService.getAllTrips();
        List<Trip> promoted = tripService.getAllPromotedTrips();
        List<Trip> lastMinuteTrips = tripService.getTripsOrderedByStartDateDesc().subList(0, 3);
        model.addAttribute("triplist",trips);
        model.addAttribute("promotedTrips",promoted);
        model.addAttribute("lastminute",lastMinuteTrips);
        return "index";
    }
}
