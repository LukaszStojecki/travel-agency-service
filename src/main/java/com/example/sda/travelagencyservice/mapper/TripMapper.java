//package com.example.sda.travelagencyservice.mapper;
//
//
//import com.example.sda.travelagencyservice.dto.TripDto;
//import com.example.sda.travelagencyservice.model.*;
//import com.example.sda.travelagencyservice.repository.TripRepository;
//import org.springframework.stereotype.Component;
//
//
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class TripMapper {
//
//    private TripRepository tripRepository;
//
//    public TripDto mapTripToDto(Trip trip) {
//        TripDto tripDto = new TripDto();
//        tripDto.setId(trip.getId());
//        tripDto.setCityFrom(trip.getCityFrom().getName());
//        tripDto.setAirportFrom(trip.getAirportFrom().getName());
//        tripDto.setCityWhere(trip.getCityWhere().getName());
//        tripDto.setAirportWhere(trip.getAirportWhere().getName());
//        tripDto.setHotelWhere(trip.getHotelWhere().getName());
//        tripDto.setStartDate(new SimpleDateFormat("dd-MM-yyyy").format(trip.getStartDate()));
//        tripDto.setEndDate(new SimpleDateFormat("dd-MM-yyyy").format(trip.getEndDate()));
//        tripDto.setDays(trip.getDays());
//        tripDto.setAccomodation(String.valueOf(trip.getAccomodation()));
//        tripDto.setAdultPrice(trip.getAdultPrice());
//        tripDto.setChildPrice(trip.getChildPrice());
//        tripDto.setPromoted(trip.isPromoted());
//        tripDto.setAdultPlaceAvailable(trip.getAdultPlaceAvailable());
//        tripDto.setChildPlaceAvailable(trip.getChildPlaceAvailable());
//
//        return tripDto;
//    }
//
////    public static List<TripDto> mapTripListToDtoList(List<Trip> tripList) {
////
////        List<TripDto> tripDtos = new ArrayList<>();
////
////        for (Trip trip : tripList) {
////            tripDtos.add(mapTripToDto(trip));
////        }
////
////        return tripDtos;
////    }
//
//    public Trip mapTripDtoToEntity(TripDto tripDto, City city, Airport airport, Hotel hotel) {
//
//        Trip trip;
//        if (tripDto.getId() == null) {
//            trip = new Trip();
//        } else {
//            trip = tripRepository.getOne(tripDto.getId());
//        }
//        trip.setCityFrom(city);
//        trip.setAirportFrom(airport);
//        trip.setCityWhere(city);
//        trip.setAirportWhere(airport);
//        trip.setHotelWhere(hotel);
//        trip.setStartDate(LocalDate.parse(tripDto.getStartDate()));
//        trip.setEndDate(LocalDate.parse(tripDto.getEndDate()));
//        trip.setDays(tripDto.getDays());
//        trip.setAccomodation(Accomodation.valueOf(tripDto.getAccomodation()));
//        trip.setAdultPrice(tripDto.getAdultPrice());
//        trip.setChildPrice(tripDto.getChildPrice());
//        trip.setPromoted(tripDto.isPromoted());
//        trip.setAdultPlaceAvailable(tripDto.getAdultPlaceAvailable());
//        trip.setChildPlaceAvailable(tripDto.getChildPlaceAvailable());
//        return trip;
//    }
//}
