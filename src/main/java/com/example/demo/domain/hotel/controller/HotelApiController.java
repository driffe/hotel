package com.example.demo.domain.hotel.controller;

import com.example.demo.domain.hotel.dto.HotelRequestDTO;
import com.example.demo.domain.hotel.dto.HotelResponseDto;
import com.example.demo.domain.hotel.entity.Hotel;
import com.example.demo.domain.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelApiController {
    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<Long> createHotel(
            @RequestBody HotelRequestDTO request) {
        return ResponseEntity.ok(hotelService.createHotel(request));
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<Long> updateHotel(
            @PathVariable Long hotelId,
            @RequestBody HotelRequestDTO request) {
        return ResponseEntity.ok(hotelService.updateHotel(hotelId, request));
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotel(
            @PathVariable Long hotelId) {
        hotelService.deleteHotel(hotelId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelService.getById(hotelId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 호텔입니다.")));
    }
    @GetMapping
    public ResponseEntity<List<HotelResponseDto>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        List<HotelResponseDto> list = hotels.stream().map(hotel -> HotelResponseDto.of(hotel)).toList();
        hotels.forEach(hotel -> log.info("hotel = {}", hotel.getId()));
        return ResponseEntity.ok(list);
    }
}
