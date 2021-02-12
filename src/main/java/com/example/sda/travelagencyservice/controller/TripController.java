package com.example.sda.travelagencyservice.controller;

import com.example.sda.travelagencyservice.exception.NotFoundException;
import com.example.sda.travelagencyservice.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
public class TripController {

    private TripService tripService;


    public TripController(TripService tripService) {
        this.tripService = tripService;
    }


    @GetMapping("/trip/{id}")
    public String showDetailsTrip(@PathVariable("id") Long id, Model model) throws NotFoundException {
        model.addAttribute("trip", tripService.findById(id));
        return "trip";
    }

    @GetMapping("/find")
    public String searchATripsByDates(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Model model) {
        model.addAttribute("search", tripService.getTripByDate(LocalDate.parse(startDate), LocalDate.parse(endDate)));
        return "index";
    }

}
