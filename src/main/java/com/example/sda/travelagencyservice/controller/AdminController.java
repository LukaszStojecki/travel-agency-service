package com.example.sda.travelagencyservice.controller;


import com.example.sda.travelagencyservice.model.Trip;
import com.example.sda.travelagencyservice.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;


@Controller
public class AdminController {

    private TripService tripService;

    public AdminController(TripService tripService) {
        this.tripService = tripService;
    }

//    @GetMapping("/admin/panel")
//    public String readAllTrips(Model model) {
//        List<Trip> trips = tripService.getAllTrips();
//        model.addAttribute("trips", trips);
//        return "/admin/panel";
//    }

    @GetMapping("/panel")
    public String getPanel( Trip trip,Model model) {
        model.addAttribute("addTrip", new Trip());
        return "/panel";
    }
    @GetMapping("/panel/add")
    public String showTrip( Trip trip,Model model) {
        model.addAttribute("addTrip", new Trip());
        return "/addTrip";
    }

    @PostMapping("/panel/add")
    public String addNewTrip(@ModelAttribute("addTrip") Trip trip,Model model) {
        tripService.createTrip(trip);
        model.addAttribute("addTrip", trip);
        return "redirect:/panel";
    }

}
