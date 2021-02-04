package com.example.sda.travelagencyservice.service;

import com.example.sda.travelagencyservice.dto.BuyTripDto;
import com.example.sda.travelagencyservice.model.BuyTrip;
import com.example.sda.travelagencyservice.model.Customer;
import com.example.sda.travelagencyservice.model.Trip;
import com.example.sda.travelagencyservice.repository.BuyTripRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BuyTripService {

    private TripService tripService;
    private BuyTripRepository buyTripRepository;
    private CustomerService customerService;

    public BuyTripService(TripService tripService, BuyTripRepository buyTripRepository, CustomerService customerService) {
        this.tripService = tripService;
        this.buyTripRepository = buyTripRepository;
        this.customerService = customerService;
    }

    public List<BuyTrip> getAllTripPurchases() {
        return buyTripRepository.findAll();
    }

    public BuyTrip createPurchaseFromDto(Long tripId, BuyTripDto buyTripDto) {
        Optional<Trip> foundTrip = tripService.findTripById(tripId);
        BuyTrip buyTrip = new BuyTrip();
        Customer customer = new Customer();
        customer.setFirstName(buyTripDto.getFirstName());
        customer.setLastName(buyTripDto.getLastName());
        customer = customerService.addNewCustomer(customer);

        buyTrip.setCustomer(customer);
        buyTrip.setAdultsQuantity(BigDecimal.valueOf(Integer.parseInt(buyTripDto.getAdultsQuantity())));
        buyTrip.setChildQuantity(BigDecimal.valueOf(Integer.parseInt(buyTripDto.getChildQuantity())));

        foundTrip.ifPresent(buyTrip::setTrip);

        if (foundTrip.isPresent()) {
            foundTrip.get()
                    .setAdultPlaceAvailable(foundTrip.get().getAdultPlaceAvailable() - Integer.parseInt(buyTripDto.getAdultsQuantity()));
            foundTrip.get()
                    .setChildPlaceAvailable(foundTrip.get().getChildPlaceAvailable() - Integer.parseInt(buyTripDto.getChildQuantity()));
        }

        return buyTripRepository.save(buyTrip);
    }

    public Optional<BuyTrip> getBuyTripById(Long id){
        return buyTripRepository.findById(id);
    }


    public BigDecimal calculateTrip(Long buyTripId) {
        Optional<BuyTrip> foundTrip = getBuyTripById(buyTripId);
        if (foundTrip.isPresent()) {
            BigDecimal childQuantity = foundTrip.get().getChildQuantity();
            BigDecimal childPrice = foundTrip.get().getTrip().getChildPrice();

            BigDecimal adultsQuantity = foundTrip.get().getAdultsQuantity();
            BigDecimal adultPrice = foundTrip.get().getTrip().getAdultPrice();

            BigDecimal adults = childQuantity.multiply(childPrice);
            BigDecimal childs = adultsQuantity.multiply(adultPrice);

            return adults.add(childs);
        }
        return null;
    }



}
