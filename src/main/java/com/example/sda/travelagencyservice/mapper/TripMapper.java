//package com.example.sda.travelagencyservice.mapper;
//
//
//import com.example.sda.travelagencyservice.dto.TripDto;
//import com.example.sda.travelagencyservice.model.Accomodation;
//import com.example.sda.travelagencyservice.model.Airport;
//import com.example.sda.travelagencyservice.model.Trip;
//import com.example.sda.travelagencyservice.service.AirportService;
//import com.example.sda.travelagencyservice.service.CityService;
//import com.example.sda.travelagencyservice.service.HotelService;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class TripMapper {
//
////    private static CityService cityService;
////    private static AirportService airportService;
////    private static HotelService hotelService;
//
////    public static TripDto mapTripToDto(Trip trip){
////
////        TripDto tripDto = new TripDto();
////        tripDto.setCityFrom(trip.getCityFrom().getId());
////        tripDto.setAirportFrom(trip.getAirportFrom().getId());
////        tripDto.setCityWhere(trip.getCityWhere().getId());
////        tripDto.setAirportWhere(trip.getAirportWhere().getId());
////        tripDto.setHotelWhere(trip.getHotelWhere().getId());
////        tripDto.setArrivalDate(LocalDateTime.parse(String.valueOf(trip.getArrival())));
////        tripDto.setDepartureDate(LocalDateTime.parse(String.valueOf(trip.getDeparture())));
////        tripDto.setDays(trip.getDays());
////        tripDto.setAccomodation(String.valueOf(trip.getAccomodation()));
////        tripDto.setAdultPrice(trip.getAdultPrice());
////        tripDto.setChildPrice(trip.getChildPrice());
////        tripDto.setPromoted(trip.isPromoted());
////        tripDto.setAdultPlaceAvailable(trip.getAdultPlaceAvailable());
////        tripDto.setChildPlaceAvailable(trip.getChildPlaceAvailable());
////
////        return tripDto;
////    }
//
////    public static List<TripDto> mapTripListToDtoList(List<Trip> tripList){
////
////        List<TripDto> tripDtos = new ArrayList<>();
////
////        for (Trip trip:tripList){
////            tripDtos.add(mapTripToDto(trip));
////        }
////
////        return tripDtos;
////    }
//
////    public static Trip mapTripDtoToEntity(TripDto tripDto){
////
////      Trip trip = new Trip();
////
////        trip.setCityFrom(cityService.findCityById(tripDto.getCityFrom()));
////        trip.setAirportFrom(airportService.findAirportById(tripDto.getAirportFrom()));
////        trip.setCityWhere(cityService.findCityById(tripDto.getCityWhere()));
////        trip.setAirportWhere(airportService.findAirportById(tripDto.getAirportWhere()));
////        trip.setHotelWhere(hotelService.findById(tripDto.getHotelWhere()));
////        trip.setArrival(LocalDate.from(tripDto.getArrivalDate()));
////        trip.setDeparture(LocalDate.from(tripDto.getDepartureDate()));
////        trip.setDays(tripDto.getDays());
////        trip.setAccomodation(Accomodation.valueOf(tripDto.getAccomodation()));
////        trip.setAdultPrice(tripDto.getAdultPrice());
////        trip.setChildPrice(tripDto.getChildPrice());
////        trip.setPromoted(tripDto.isPromoted());
////        trip.setAdultPlaceAvailable(tripDto.getAdultPlaceAvailable());
////        trip.setChildPlaceAvailable(tripDto.getChildPlaceAvailable());
////        return trip;
////    }
//}
