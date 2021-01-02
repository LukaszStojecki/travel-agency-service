package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.HotelDto;
import com.example.sda.travelagencyservice.model.Hotel;
import com.example.sda.travelagencyservice.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private HotelRepository hotelRepository;
    private CityService cityService;

    public HotelService(HotelRepository hotelRepository, CityService cityService) {
        this.hotelRepository = hotelRepository;
        this.cityService = cityService;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel addNewHotel(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelDto.getId());
        hotel.setName(hotelDto.getName());
        hotel.setCity(cityService.findCityById(hotelDto.getCityId()));
        hotel.setDescription(hotel.getDescription());
        hotel.setRating(hotelDto.getRating());
        return hotelRepository.save(hotel);
    }
    public Hotel findById(Long hotelID) {
        return hotelRepository.getOne(hotelID);
    }
    public Hotel findHotelByName(String name){
        return hotelRepository.findHotelByName(name);
    }
}
