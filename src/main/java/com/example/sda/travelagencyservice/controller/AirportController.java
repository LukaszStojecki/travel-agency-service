package com.example.sda.travelagencyservice.controller;


import com.example.sda.travelagencyservice.dto.AirportDto;
import com.example.sda.travelagencyservice.dto.CityDto;
import com.example.sda.travelagencyservice.service.AirportService;
import com.example.sda.travelagencyservice.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AirportController {

    private AirportService airportService;
    private CityService cityService;

    public AirportController(AirportService airportService, CityService cityService) {
        this.airportService = airportService;
        this.cityService = cityService;
    }
    @GetMapping("/airport/list")
    public String getAllAirports(Model model){

        List<AirportDto> airportDTOS = airportService.getAllAirports();
        model.addAttribute("airportList",airportDTOS);

        return "airportList";
    }

    @GetMapping("/panel/add/airport")
    public String createAirport(Model model){
        List<CityDto> cityDtos = cityService.getAllCities();
        model.addAttribute("airport",new AirportDto());
        model.addAttribute("cities",cityDtos);

        return "addAirport";
    }

    @PostMapping("/panel/add/airport")
    public String createAirport(@ModelAttribute("airport") AirportDto airportDTO) throws Exception {
        System.out.println("Dane: " + airportDTO);
        airportService.saveAirport(airportDTO);
        return "redirect:/airport/list";
    }
}
