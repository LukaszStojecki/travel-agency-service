package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.TripDto;
import com.example.sda.travelagencyservice.model.*;
import com.example.sda.travelagencyservice.repository.TripRepository;
import com.example.sda.travelagencyservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripService {

    private TripRepository tripRepository;
    private CityService cityService;
    private AirportService airportService;
    private HotelService hotelService;
    private UserRepository userRepository;

    public TripService(TripRepository tripRepository, CityService cityService, AirportService airportService, HotelService hotelService, UserRepository userRepository) {
        this.tripRepository = tripRepository;
        this.cityService = cityService;
        this.airportService = airportService;
        this.hotelService = hotelService;
        this.userRepository = userRepository;
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip addNewTrip(Trip trip) {
        return tripRepository.save(trip);
    }

//    public List<Trip> getAllLastMinuteTrip() {
//        return tripRepository.findAll().stream()
//                .filter(trip -> trip.getStartDate().isAfter(ChronoLocalDate.from(LocalDateTime.now())))
//                .sorted(Comparator.comparing(Trip::getStartDate))
//                .collect(Collectors.toList());
//    }

    public List<Trip> getTripsOrderedByStartDateDesc() {
        List<Trip> trips = tripRepository.findAll();
        trips.sort(Comparator.comparing(Trip::getStartDate).reversed());
        return trips;
    }

    public List<Trip> getAllPromotedTrips() {
        return tripRepository.findAll().stream()
                .filter(Trip::isPromoted)
                .collect(Collectors.toList());
    }


//    public Trip getTripById(Long id) {
//        return tripRepository.getOne(id);
//    }

    public Optional<Trip> findTripById(Long id) {
        return tripRepository.findById(id);
    }

    public List<Trip> getTripByDate(LocalDate startDate, LocalDate endDate) {
        List<Trip> tripList = tripRepository.findTripByStartDateAndEndDate(startDate, endDate);
        return tripList;
    }

    public Trip mapDtoToEntity(TripDto tripDto) {
        Trip trip;
        if (tripDto.getId() == null) {
            trip = new Trip();
        } else {
            trip = findTripById(tripDto.getId()).get();
        }
        trip.setCityFrom(cityService.findCityName(tripDto.getCityFrom()));
        trip.setAirportFrom(airportService.findByName(tripDto.getAirportFrom()));
        trip.setCityWhere(cityService.findCityName(tripDto.getCityWhere()));
        trip.setAirportWhere(airportService.findByName(tripDto.getAirportWhere()));
        trip.setHotelWhere(hotelService.findHotelByName(tripDto.getHotelWhere()));
        trip.setStartDate(LocalDate.parse(tripDto.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-d")));
        trip.setEndDate(LocalDate.parse(tripDto.getEndDate(),DateTimeFormatter.ofPattern("yyyy-MM-d")));
        trip.setDays(tripDto.getDays());
        trip.setAccomodation(Accomodation.valueOf(tripDto.getAccomodation()));
        trip.setAdultPrice(tripDto.getAdultPrice());
        trip.setChildPrice(tripDto.getChildPrice());
        trip.setPromoted(tripDto.isPromoted());
        trip.setAdultPlaceAvailable(tripDto.getAdultPlaceAvailable());
        trip.setChildPlaceAvailable(tripDto.getChildPlaceAvailable());
        return tripRepository.save(trip);
    }

    public TripDto mapTripToDto(Trip trip) {
        TripDto tripDto = new TripDto();
        tripDto.setId(trip.getId());
        tripDto.setCityFrom(trip.getCityFrom().getName());
        tripDto.setAirportFrom(trip.getAirportFrom().getName());
        tripDto.setCityWhere(trip.getCityWhere().getName());
        tripDto.setAirportWhere(trip.getAirportWhere().getName());
        tripDto.setHotelWhere(trip.getHotelWhere().getName());
        tripDto.setStartDate(trip.getStartDate().toString());
        tripDto.setEndDate(trip.getEndDate().toString());
        tripDto.setDays(trip.getDays());
        tripDto.setAccomodation(trip.getAccomodation().toString());
        tripDto.setAdultPrice(trip.getAdultPrice());
        tripDto.setChildPrice(trip.getChildPrice());
        tripDto.setPromoted(trip.isPromoted());
        tripDto.setAdultPlaceAvailable(trip.getAdultPlaceAvailable());
        tripDto.setChildPlaceAvailable(trip.getChildPlaceAvailable());
        return tripDto;
    }



}

