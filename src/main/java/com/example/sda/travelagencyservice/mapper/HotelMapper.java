package com.example.sda.travelagencyservice.mapper;

import com.example.sda.travelagencyservice.dto.HotelDto;
import com.example.sda.travelagencyservice.model.City;
import com.example.sda.travelagencyservice.model.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public Hotel mapToHotel(HotelDto hotelDto, City city){
        return Hotel.builder()
                .name(hotelDto.getName())
                .description(hotelDto.getDescription())
                .rating(hotelDto.getRating())
                .city(city)
                .build();
    }

    public HotelDto mapHotelEntityToDto(Hotel hotel){
        return HotelDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .description(hotel.getDescription())
                .rating(hotel.getRating())
                .cityId(hotel.getCity().getId())
                .build();
    }

}
