package com.example.demo.domain.hotel.service;

import com.example.demo.domain.hotel.dto.HotelRequestDTO;
import com.example.demo.domain.hotel.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Long createHotel(HotelRequestDTO dto);
    Long updateHotel(Long hotelId, HotelRequestDTO dto);
    void deleteHotel(Long hotelId);
    Optional<Hotel> getById(Long hotelId);

    List<Hotel> getAllHotels();
}
