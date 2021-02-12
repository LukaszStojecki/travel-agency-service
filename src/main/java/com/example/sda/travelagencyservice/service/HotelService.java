package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.HotelDto;
import com.example.sda.travelagencyservice.exception.ConflictException;
import com.example.sda.travelagencyservice.exception.NotFoundException;
import com.example.sda.travelagencyservice.mapper.HotelMapper;
import com.example.sda.travelagencyservice.model.City;
import com.example.sda.travelagencyservice.model.Hotel;
import com.example.sda.travelagencyservice.repository.CityRepository;
import com.example.sda.travelagencyservice.repository.HotelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private HotelRepository hotelRepository;
    private HotelMapper hotelMapper;
    private CityRepository cityRepository;

    public HotelService(HotelRepository hotelRepository, HotelMapper hotelMapper, CityRepository cityRepository) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
        this.cityRepository = cityRepository;
    }


    public List<HotelDto> getAllHotel(){
        return hotelRepository.findAll().stream()
                .map(hotel -> hotelMapper.mapHotelEntityToDto(hotel))
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveHotel(HotelDto hotelDto) throws ConflictException, NotFoundException {
        City city = cityRepository.findById(hotelDto.getCityId()).orElseThrow(()-> new NotFoundException("City not found" + hotelDto.getCityId().toString()));
        if (hotelRepository.existsByName(hotelDto.getName())){
            throw new ConflictException("Hotel already exists: " + hotelDto.getName());
        }
        Hotel hotel = hotelMapper.mapToHotel(hotelDto, city);
        hotelRepository.save(hotel);

    }
}
