package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.TripDto;
import com.example.sda.travelagencyservice.exception.BadRequestException;
import com.example.sda.travelagencyservice.exception.NotFoundException;
import com.example.sda.travelagencyservice.exception.PlaceAvailable;
import com.example.sda.travelagencyservice.mapper.TripMapper;
import com.example.sda.travelagencyservice.model.*;
import com.example.sda.travelagencyservice.repository.*;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    private TripRepository tripRepository;
    private TripMapper tripMapper;
    private CityRepository cityRepository;
    private AirportRepository airportRepository;
    private HotelRepository hotelRepository;
    private CountryRepository countryRepository;
    private ContinentRepository continentRepository;

    public TripService(TripRepository tripRepository, TripMapper tripMapper, CityRepository cityRepository,
                       AirportRepository airportRepository, HotelRepository hotelRepository,
                       CountryRepository countryRepository, ContinentRepository continentRepository) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
        this.cityRepository = cityRepository;
        this.airportRepository = airportRepository;
        this.hotelRepository = hotelRepository;
        this.countryRepository = countryRepository;
        this.continentRepository = continentRepository;
    }


    public List<TripDto> getAllTrip() {
        return tripRepository.findAll().stream()
                .map(trip -> tripMapper.mapTripEntityToDto(trip))
                .collect(Collectors.toList());
    }

    public void saveTrip(TripDto tripDto) throws BadRequestException {

        String today = String.valueOf(LocalDate.now());

        if (tripDto.getStartDate().compareTo(tripDto.getEndDate()) > 0) {
            throw new BadRequestException("End date before start date");
        }
        if (tripDto.getStartDate().compareTo(today) < 0) {
            throw new BadRequestException("You can't add a trip with yesterday's date");
        }
        City departureCity;
        departureCity = cityRepository.findByName(tripDto.getDepartureCity()).orElseThrow();
        City arrivalCity = cityRepository.findByName(tripDto.getArrivalCity()).orElseThrow();
        Airport departureAirport = airportRepository.findByName(tripDto.getDepartureAirport()).orElseThrow();
        Airport arrivalAirport = airportRepository.findByName(tripDto.getArrivalAirport()).orElseThrow();
        Hotel hotel = hotelRepository.findByName(tripDto.getHotel()).orElseThrow();

        Trip trip = tripMapper.mapToTrip(tripDto, departureCity, arrivalCity, departureAirport, arrivalAirport, hotel);
        tripRepository.save(trip);
    }

    public TripDto updateTrip(Long id, TripDto tripDto) throws NotFoundException, BadRequestException {
        if (tripDto.getStartDate().compareTo(tripDto.getEndDate()) > 0) {
            throw new BadRequestException("End date before start date");
        }
        Trip trip = tripRepository.findById(id).orElseThrow(() -> new NotFoundException("Trip not found"));
        City departureCity = cityRepository.findByName(tripDto.getDepartureCity()).orElseThrow();
        City arrivalCity = cityRepository.findByName(tripDto.getArrivalCity()).orElseThrow();
        Airport departureAirport = airportRepository.findByName(tripDto.getDepartureAirport()).orElseThrow();
        Airport arrivalAirport = airportRepository.findByName(tripDto.getArrivalAirport()).orElseThrow();
        Hotel hotel = hotelRepository.findByName(tripDto.getHotel()).orElseThrow();
        trip.setArrivalCity(arrivalCity);
        trip.setDepartureCity(departureCity);
        trip.setDepartureAirport(departureAirport);
        trip.setArrivalAirport(arrivalAirport);
        trip.setHotel(hotel);
        trip.setStartDate(LocalDate.parse(tripDto.getStartDate()));
        trip.setEndDate(LocalDate.parse(tripDto.getEndDate()));
        trip.setDays(tripDto.getDays());
        trip.setAccomodation(Accomodation.valueOf(tripDto.getAccomodation()));
        trip.setAdultPrice(tripDto.getAdultPrice());
        trip.setChildPrice(tripDto.getChildPrice());
        trip.setPromoted(tripDto.isPromoted());
        trip.setAdultPlaceAvailable(tripDto.getAdultPlaceAvailable());
        trip.setChildPlaceAvailable(tripDto.getChildPlaceAvailable());

        Trip updateTrip = tripRepository.save(trip);
        return tripMapper.mapTripEntityToDto(updateTrip);

    }

    public TripDto findById(Long id) throws NotFoundException {
        return tripRepository.findById(id)
                .map(trip -> tripMapper.mapTripEntityToDto(trip))
                .orElseThrow(() -> new NotFoundException("Trip of id " + id + ", doesn't exist"));

    }

    public void deleteById(Long id) {
        tripRepository.deleteById(id);
    }

    public List<TripDto> getAllPromotedTrips() {
        return tripRepository.findAll().stream()
                .filter(Trip::isPromoted)
                .filter(trip -> trip.getStartDate().isAfter(LocalDate.now().minusDays(1)))
                .map(trip -> tripMapper.mapTripEntityToDto(trip))
                .collect(Collectors.toList());
    }

    public List<TripDto> getLastMinuteTrips() {
        return tripRepository.findAll().stream()
                .filter(trip -> trip.getStartDate().isAfter(LocalDate.now().minusDays(1)))
                .map(trip -> tripMapper.mapTripEntityToDto(trip))
                .collect(Collectors.toList());
    }

    public List<TripDto> getAllLastMinuteTripByCity(String arrivalCity) throws NotFoundException {
        City city = cityRepository.findByName(arrivalCity).orElseThrow(() -> new NotFoundException("City not found " + arrivalCity));
        return tripRepository.findByArrivalCity(city).stream()
                .map(trip -> tripMapper.mapTripEntityToDto(trip))
                .collect(Collectors.toList());
    }
    @Transactional
    public List<TripDto> getAllLastMinuteTripByCountry(String name) throws NotFoundException {
        Country country = countryRepository.findByName(name).orElseThrow(() -> new NotFoundException("Country not found " + name));
        return tripRepository.findByArrivalCityCountry(country).stream()
                .filter(trip -> trip.getStartDate().isAfter(LocalDate.now().minusDays(1)))
                .map(trip -> tripMapper.mapTripEntityToDto(trip))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TripDto> getAllLastMinuteTripByContinent(String name) throws NotFoundException {
        Continent continent = continentRepository.findByName(name).orElseThrow(() -> new NotFoundException("Continent not found " + name));
        return tripRepository.findByArrivalCityCountryContinent(continent).stream()
                .filter(trip -> trip.getStartDate().isAfter(LocalDate.now().minusDays(1)))
                .map(trip -> tripMapper.mapTripEntityToDto(trip))
                .collect(Collectors.toList());
    }

    public List<TripDto> getTripByDate(LocalDate startDate, LocalDate endDate) {
            return tripRepository.findTripByStartDateAndEndDate(startDate, endDate).stream()
                    .map(trip -> tripMapper.mapTripEntityToDto(trip))
                    .collect(Collectors.toList());
    }

    public boolean checkPlaceAvailable(Trip trip, Integer childQuantity, Integer adultsQuantity) throws PlaceAvailable, NotFoundException {
        TripDto tripSearch = findById(trip.getId());
        if (tripSearch.getChildPlaceAvailable() >= childQuantity || tripSearch.getAdultPlaceAvailable() >= adultsQuantity) {
            return true;
        } else {
            throw new PlaceAvailable("Brak wolnych miejsc");
        }
    }
}

