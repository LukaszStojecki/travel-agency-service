package com.example.sda.travelagencyservice.mapper;

import com.example.sda.travelagencyservice.dto.TripPurchaseDto;
import com.example.sda.travelagencyservice.model.Trip;
import com.example.sda.travelagencyservice.model.TripPurchase;
import com.example.sda.travelagencyservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class TripPurchaseMapper {


    public TripPurchase mapToTripPurchase(TripPurchaseDto tripPurchaseDto, Trip trip, User user){
        if(tripPurchaseDto==null){
            return null;
        }else {
            return TripPurchase.builder()
                    .trip(trip)
                    .user(user)
                    .adultsQuantity(tripPurchaseDto.getAdultsQuantity())
                    .childQuantity(tripPurchaseDto.getChildrenQuantity())
                    .amount(tripPurchaseDto.getAmount())
                    .build();
        }
    }

    public TripPurchaseDto mapPurchaseToDto(TripPurchase tripPurchase) {
        if (tripPurchase==null){
            return null;
        }else {
            return TripPurchaseDto.builder()
                    .id(tripPurchase.getId())
                    .tripPurchase(tripPurchase.getTrip().getArrivalCity().getName())
                    .userPurchase(tripPurchase.getUser().getUsername())
                    .adultsQuantity(tripPurchase.getAdultsQuantity())
                    .childrenQuantity(tripPurchase.getChildQuantity())
                    .amount(tripPurchase.getAmount())
                    .build();
        }
    }
}
