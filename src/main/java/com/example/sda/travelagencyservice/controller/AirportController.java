package com.example.sda.travelagencyservice.controller;


import com.example.sda.travelagencyservice.dto.AirportDto;
import com.example.sda.travelagencyservice.model.Airport;
import com.example.sda.travelagencyservice.service.AirportService;
import com.example.sda.travelagencyservice.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AirportController {

    private AirportService airportService;
    private CityService cityService;

    public AirportController(AirportService airportService, CityService cityService) {
        this.airportService = airportService;
        this.cityService = cityService;
    }

    @GetMapping("/panel/add/airport")
    public String showAddAirportForm(Model model) {
        model.addAttribute("addAirport", new AirportDto());
        model.addAttribute("cities",cityService.getAllCities());
        return "addAirport";
    }

    @PostMapping("/panel/add/airport")
    public String addNewAirport(@ModelAttribute(name = "addAirport") AirportDto airportDto, Model model) {
        model.addAttribute("addAirport", airportDto);
        airportService.addAirports(airportDto);
        return "redirect:/panel";
    }
}
