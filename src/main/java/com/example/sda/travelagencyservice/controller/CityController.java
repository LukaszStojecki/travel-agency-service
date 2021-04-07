package com.example.sda.travelagencyservice.controller;

import com.example.sda.travelagencyservice.dto.CityDto;
import com.example.sda.travelagencyservice.dto.CountryDto;
import com.example.sda.travelagencyservice.service.CityService;
import com.example.sda.travelagencyservice.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class CityController {

    private CityService cityService;
    private CountryService countryService;

    public CityController(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
    }


    @GetMapping("/city/list")
    public String getAllCity(Model model){

        List<CityDto> cityDtos = cityService.getAllCities();
        model.addAttribute("cityList",cityDtos);

        return "cityList";
    }

    @GetMapping("/panel/add/city")
    public String createCity(Model model){
        List<CountryDto> countryDtos = countryService.getAllCountries();
        model.addAttribute("city",new CityDto());
        model.addAttribute("countries",countryDtos);

        return "addCity";
    }

    @PostMapping("/panel/add/city")
    public String createCity(@ModelAttribute("city") CityDto cityDto) throws Exception {
        System.out.println("Dane: " + cityDto);
        cityService.saveCity(cityDto);
        return "redirect:/city/list";
    }
}
