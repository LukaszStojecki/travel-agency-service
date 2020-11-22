package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.HotelDto;
import com.example.sda.travelagencyservice.model.Hotel;
import com.example.sda.travelagencyservice.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public void addNewHotel(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDto.getName());
        hotel.setCity(hotelDto.getCityId());
        hotel.setDescription(hotel.getDescription());
        hotel.setRating(hotelDto.getRating());
        hotelRepository.save(hotel);
    }
}
