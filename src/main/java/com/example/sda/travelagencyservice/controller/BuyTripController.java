package com.example.sda.travelagencyservice.controller;

import com.example.sda.travelagencyservice.dto.BuyTripDto;
import com.example.sda.travelagencyservice.model.BuyTrip;
import com.example.sda.travelagencyservice.model.Trip;
import com.example.sda.travelagencyservice.service.BuyTripService;
import com.example.sda.travelagencyservice.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuyTripController {

    private BuyTripService buyTripService;
    private TripService tripService;


    public BuyTripController(BuyTripService buyTripService, TripService tripService) {
        this.buyTripService = buyTripService;
        this.tripService = tripService;
    }


    @GetMapping("/buyTrip/{tripId}")
    public String buyTrip(@PathVariable Long tripId, Model model) {
        Trip trip = tripService.findTripById(tripId).get();
        BuyTripDto buyTripDto = new BuyTripDto();

//        model.addAttribute("trip",trip);
        model.addAttribute("tripPurchase",buyTripDto);
        buyTripDto.setAdultsAvailable(String.valueOf(trip.getAdultPlaceAvailable()));
        buyTripDto.setChildAvailable(String.valueOf(trip.getChildPlaceAvailable()));
        buyTripDto.setAdultsQuantity("2");
        buyTripDto.setChildQuantity("0");
        return "buyTrip";
    }

    @PostMapping("/buyTrip/{tripId}")
    public String buyATripPost(@PathVariable Long tripId,
                               @ModelAttribute("tripPurchase") BuyTripDto buyTripDto, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult);
            return "buyTrip";
        }

        BuyTrip purchase = buyTripService.createPurchaseFromDto(tripId, buyTripDto);
        model.addAttribute("purchaseId",purchase.getId());
        return "redirect:/purchase/purchase-summary/" + purchase.getId();
    }

    @GetMapping("/purchase/purchase-summary/{purchaseId}")
    public String showYourPurchase(@PathVariable("purchaseId") Long purchaseId,
                                   Model model) {
        model.addAttribute("tripPurchase", buyTripService.getBuyTripById(purchaseId).get());
        model.addAttribute("amountOfMoney", buyTripService.calculateTrip(purchaseId));
        return "result";
    }

    @PostMapping("/purchase/purchase-summary")
    public String showYourPurchasePost() {
        return "result";
    }
}
