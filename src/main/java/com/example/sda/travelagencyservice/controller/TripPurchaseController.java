package com.example.sda.travelagencyservice.controller;

import com.example.sda.travelagencyservice.dto.TripDto;
import com.example.sda.travelagencyservice.dto.TripPurchaseDto;
import com.example.sda.travelagencyservice.dto.UserDto;
import com.example.sda.travelagencyservice.exception.NotFoundException;
import com.example.sda.travelagencyservice.exception.PlaceAvailable;
import com.example.sda.travelagencyservice.mapper.UserMapper;
import com.example.sda.travelagencyservice.model.User;
import com.example.sda.travelagencyservice.service.TripPurchaseService;
import com.example.sda.travelagencyservice.service.TripService;
import com.example.sda.travelagencyservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class TripPurchaseController {

    private TripPurchaseService tripPurchaseService;
    private TripService tripService;
    private UserService userService;

    public TripPurchaseController(TripPurchaseService tripPurchaseService, TripService tripService,
                                  UserService userService) {
        this.tripPurchaseService = tripPurchaseService;
        this.tripService = tripService;
        this.userService = userService;
    }

    @GetMapping("/buyTrip/{tripId}")
    public String buyTrip(@PathVariable("tripId") Long tripId, Model model, Principal principal) throws NotFoundException {
        TripDto tripDto = tripService.findById(tripId);
        TripPurchaseDto tripPurchaseDto = new TripPurchaseDto();
        if (principal != null){
            model.addAttribute("username", principal.getName());
        } else{
            model.addAttribute("username", "Unknown");
        }
        model.addAttribute("TripPurchase", tripPurchaseDto);
        model.addAttribute("trip",tripDto);

        return "buyTrip";
    }

    @PostMapping("/buyTrip/{tripId}")
    public String buyTrip(@PathVariable("tripId") Long tripId, @ModelAttribute("TripPurchase") TripPurchaseDto tripPurchaseDto,
                          BindingResult bindingResult, Model model, Principal principal)
            throws NotFoundException, PlaceAvailable {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult);
            return "buyTrip";
        }

        TripPurchaseDto purchaseDto = tripPurchaseService.buyTrip(tripId, tripPurchaseDto,principal);
        model.addAttribute("username",principal.getName());
        model.addAttribute("purchaseId", purchaseDto.getId());
        return "redirect:/purchase/purchase-summary/" + purchaseDto.getId();
    }

    @GetMapping("/purchase/purchase-summary/{purchaseId}")
    public String showYourPurchase(@PathVariable("purchaseId") Long purchaseId, Model model) throws NotFoundException {
        model.addAttribute("tripPurchase", tripPurchaseService.findById(purchaseId));
        model.addAttribute("amount",tripPurchaseService.calculateTrip(purchaseId));
        return "result";
    }

    @PostMapping("/purchase/purchase-summary")
    public String showYourPurchasePost() {
        return "result";
    }

    @GetMapping("/purchase")
    public String getAllPurchaseByUsers( Model model, Principal principal) throws NotFoundException {
        User user = userService.getUserByEmail(principal.getName());
        List<TripPurchaseDto> tripPurchaseDto = tripPurchaseService.getAllPurchaseTripByUser(user);

        model.addAttribute("purchases",tripPurchaseDto);
        return "purchaseList";
    }
}
