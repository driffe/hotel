package com.example.demo.domain.hotel.controller;

import com.example.demo.domain.hotel.dto.HotelRequestDTO;
import com.example.demo.domain.hotel.entity.Hotel;
import com.example.demo.domain.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Hotel API", description = "Hotel API")
@ApiResponse(responseCode = "2000", description = "Success")
@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelApiController {
    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<Long> createHotel(
            @RequestParam String username,
            @RequestBody HotelRequestDTO request) {
        return ResponseEntity.ok(hotelService.createHotel(username, request));
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<Long> updateHotel(
            @RequestParam String username,
            @PathVariable Long hotelId,
            @RequestBody HotelRequestDTO request) {
        return ResponseEntity.ok(hotelService.updateHotel(username, hotelId, request));
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotel(
            @RequestParam String username,
            @PathVariable Long hotelId) {
        hotelService.deleteHotel(username, hotelId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelService.getById(hotelId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 호텔입니다.")));
    }
}
