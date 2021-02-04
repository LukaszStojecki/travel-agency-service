package com.example.sda.travelagencyservice.controller;

import com.example.sda.travelagencyservice.dto.BuyTripDto;
import com.example.sda.travelagencyservice.model.BuyTrip;
import com.example.sda.travelagencyservice.model.Trip;
import com.example.sda.travelagencyservice.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
public class TripController {

    private TripService tripService;
    private CountryService countryService;
    private CityService cityService;
    private HotelService hotelService;
    private BuyTripService buyTripService;

    public TripController(TripService tripService, CountryService countryService, CityService cityService, HotelService hotelService, BuyTripService buyTripService) {
        this.tripService = tripService;
        this.countryService = countryService;
        this.cityService = cityService;
        this.hotelService = hotelService;
        this.buyTripService = buyTripService;
    }


    @GetMapping("/trip/{id}")
    public String showDetailsTrip(@PathVariable("id") Long id, Model model) {
        model.addAttribute("trip", tripService.findTripById(id).get());
        return "trip";
    }

    @GetMapping("/find")
    public String searchATripsByDates(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Model model) {
        model.addAttribute("search", tripService.getTripByDate(LocalDate.parse(startDate), LocalDate.parse(endDate)));
        return "index";
    }

}
