package com.example.sda.travelagencyservice.mapper;

import com.example.sda.travelagencyservice.dto.TripDto;
import com.example.sda.travelagencyservice.model.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TripMapper {

    public Trip mapToTrip(TripDto tripDto, City arrivalCity, City departureCity,
                          Airport departureAirport, Airport arrivalAirport, Hotel hotel){
        return Trip.builder()
                .departureCity(departureCity)
                .arrivalCity(arrivalCity)
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .hotel(hotel)
                .startDate(LocalDate.parse(tripDto.getStartDate()))
                .endDate(LocalDate.parse(tripDto.getEndDate()))
                .days(tripDto.getDays())
                .accomodation(Accomodation.valueOf(tripDto.getAccomodation()))
                .adultPrice(tripDto.getAdultPrice())
                .childPrice(tripDto.getChildPrice())
                .adultPlaceAvailable(tripDto.getAdultPlaceAvailable())
                .childPlaceAvailable(tripDto.getChildPlaceAvailable())
                .isPromoted(tripDto.isPromoted())
                .build();
    }

    public TripDto mapTripEntityToDto(Trip trip){
        return TripDto.builder()
                .id(trip.getId())
                .departureCity(trip.getDepartureCity().getName())
                .arrivalCity(trip.getArrivalCity().getName())
                .departureAirport(trip.getDepartureAirport().getName())
                .arrivalAirport(trip.getArrivalAirport().getName())
                .hotel(trip.getHotel().getName())
                .days(trip.getDays())
                .accomodation(trip.getAccomodation().toString())
                .adultPrice(trip.getAdultPrice())
                .childPrice(trip.getChildPrice())
                .adultPlaceAvailable(trip.getAdultPlaceAvailable())
                .childPlaceAvailable(trip.getChildPlaceAvailable())
                .startDate(trip.getStartDate().toString())
                .endDate(trip.getEndDate().toString())
                .isPromoted(trip.isPromoted())
                .build();
    }

}
