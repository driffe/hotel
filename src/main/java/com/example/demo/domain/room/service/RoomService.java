package com.example.demo.domain.room.service;

import com.example.demo.domain.room.dto.RoomResponseDto;
import com.example.demo.domain.room.entity.RoomType;

import java.util.List;

public interface RoomService {
    List<RoomResponseDto> getRoomsByHotel(Long hotelId);
    List<RoomResponseDto> getAvailableRooms(Long hotelId, RoomType roomType);
}
