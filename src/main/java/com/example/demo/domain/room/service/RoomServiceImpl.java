package com.example.demo.domain.room.service;

import com.example.demo.domain.hotel.entity.Hotel;
import com.example.demo.domain.hotel.repository.HotelRepository;
import com.example.demo.domain.room.dto.RoomResponseDto;
import com.example.demo.domain.room.entity.RoomType;
import com.example.demo.domain.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Override
    public List<RoomResponseDto> getRoomsByHotel(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 호텔."));

        return roomRepository.findByHotelId(hotelId).stream()
                .map(RoomResponseDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomResponseDto> getAvailableRooms(Long hotelId, RoomType roomType) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 호텔."));

        return roomRepository.findByHotelIdAndTypeAndStatus(hotelId, roomType, true).stream()
                .map(RoomResponseDto::of)
                .collect(Collectors.toList());
    }
}
