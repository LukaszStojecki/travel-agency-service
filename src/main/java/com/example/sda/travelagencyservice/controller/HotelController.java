package com.example.sda.travelagencyservice.controller;


import com.example.sda.travelagencyservice.dto.CityDto;
import com.example.sda.travelagencyservice.dto.HotelDto;
import com.example.sda.travelagencyservice.service.CityService;
import com.example.sda.travelagencyservice.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HotelController {

    private HotelService hotelService;
    private CityService cityService;

    public HotelController(HotelService hotelService, CityService cityService) {
        this.hotelService = hotelService;
        this.cityService = cityService;
    }

    @GetMapping("/hotel/list")
    public String getAllHotel(Model model){

        List<HotelDto> hotelDtos = hotelService.getAllHotel();
        model.addAttribute("hotelList",hotelDtos);

        return "hotelList";
    }

    @GetMapping("/panel/add/hotel")
    public String createHotel(Model model){
        List<CityDto> cityDtos = cityService.getAllCities();
        model.addAttribute("hotel",new HotelDto());
        model.addAttribute("cities",cityDtos);

        return "addHotel";
    }

    @PostMapping("/panel/add/hotel")
    public String createHotel(@ModelAttribute("hotel") HotelDto hotelDto) throws Exception {
        System.out.println("Dane: " + hotelDto);
        hotelService.saveHotel(hotelDto);
        return "redirect:/hotel/list";
    }
}
