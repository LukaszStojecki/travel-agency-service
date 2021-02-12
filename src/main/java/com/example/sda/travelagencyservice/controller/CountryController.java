package com.example.sda.travelagencyservice.controller;


import com.example.sda.travelagencyservice.dto.ContinentDto;
import com.example.sda.travelagencyservice.dto.CountryDto;
import com.example.sda.travelagencyservice.service.ContinentService;
import com.example.sda.travelagencyservice.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CountryController {

    private CountryService countryService;
    private ContinentService continentService;

    public CountryController(CountryService countryService, ContinentService continentService) {
        this.countryService = countryService;
        this.continentService = continentService;
    }


    @GetMapping("/country/list")
    public String getAllCountry(Model model){

        List<CountryDto> countryDtos = countryService.getAllCountries();
        model.addAttribute("countries",countryDtos);

        return "countryList";
    }

    @GetMapping("/panel/add/country")
    public String createCountry(Model model){
        List<ContinentDto> continentDtos = continentService.getAllContinents();
        model.addAttribute("country",new CountryDto());
        model.addAttribute("continents",continentDtos);

        return "addCountry";
    }

    @PostMapping("/panel/add/country")
    public String createCountry(@ModelAttribute("country") CountryDto countryDto) throws Exception {
        System.out.println("Dane: " + countryDto);
        countryService.saveCountry(countryDto);
        return "redirect:/country/list";
    }
}
