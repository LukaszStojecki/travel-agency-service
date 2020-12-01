package com.example.sda.travelagencyservice.controller;


import com.example.sda.travelagencyservice.dto.CityDto;
import com.example.sda.travelagencyservice.dto.CountryDto;
import com.example.sda.travelagencyservice.service.ContinentService;
import com.example.sda.travelagencyservice.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CountryController {

    private CountryService countryService;
    private ContinentService continentService;


    public CountryController(CountryService countryService, ContinentService continentService) {
        this.countryService = countryService;
        this.continentService = continentService;
    }

    @GetMapping("/panel/add/country")
    public String showAddCountryForm(Model model) {
        model.addAttribute("addCountry", new CountryDto());
        model.addAttribute("continents",continentService.getAllContinents());
        return "addCountry";
    }

    @PostMapping("/panel/add/country")
    public String addNewCountry(@ModelAttribute(name = "addCountry") CountryDto countryDto, Model model) {
        model.addAttribute("addCountry", countryDto);
        countryService.addCountries(countryDto);
        return "redirect:/panel";
    }

}
