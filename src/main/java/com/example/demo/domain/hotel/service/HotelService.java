package com.example.demo.domain.hotel.service;

import com.example.demo.domain.hotel.dto.HotelRequestDTO;
import com.example.demo.domain.hotel.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Long createHotel(String username, HotelRequestDTO dto);
    Long updateHotel(String username, Long hotelId, HotelRequestDTO dto);
    void deleteHotel(String username, Long hotelId);
    Optional<Hotel> getById(Long hotelId);
}
