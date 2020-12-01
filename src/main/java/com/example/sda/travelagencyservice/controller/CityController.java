package com.example.sda.travelagencyservice.controller;

import com.example.sda.travelagencyservice.dto.CityDto;
import com.example.sda.travelagencyservice.model.City;
import com.example.sda.travelagencyservice.service.CityService;
import com.example.sda.travelagencyservice.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CityController {

    private CityService cityService;
    private CountryService countryService;

    public CityController(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @GetMapping("/panel/add/city")
    public String showAddCityForm(Model model) {
        model.addAttribute("addCity", new CityDto());
        model.addAttribute("countries",countryService.getAllCountry());
        return "addCity";
    }

    @PostMapping("/panel/add/city")
    public String addNewCity(@ModelAttribute(name = "addCity") CityDto cityDto, Model model) {
        model.addAttribute("addCity", cityDto);
        cityService.addNewCity(cityDto);
        return "redirect:/panel";
    }
}
