package com.example.sda.travelagencyservice.controller;


import com.example.sda.travelagencyservice.dto.HotelDto;
import com.example.sda.travelagencyservice.service.CityService;
import com.example.sda.travelagencyservice.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HotelController {

    private HotelService hotelService;
    private CityService cityService;

    public HotelController(HotelService hotelService, CityService cityService) {
        this.hotelService = hotelService;
        this.cityService = cityService;
    }

    @GetMapping("/panel/add/hotel")
    public String showAddHotelForm(Model model) {
        model.addAttribute("cities",cityService.getAllCities());
        model.addAttribute("addHotel", new HotelDto());
        return "addHotel";
    }

    @PostMapping("/panel/add/hotel")
    public String addNewHotel(@ModelAttribute(name = "addHotel") HotelDto hotelDto, Model model) {
        model.addAttribute("addHotel", hotelDto);
        hotelService.addNewHotel(hotelDto);
        return "redirect:/panel";
    }
}
