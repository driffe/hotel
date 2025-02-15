package com.example.demo.domain.room.controller;

import com.example.demo.domain.room.dto.RoomResponseDto;
import com.example.demo.domain.room.entity.RoomType;
import com.example.demo.domain.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomApiController {
    private final RoomService roomService;

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<RoomResponseDto>> getRoomsByHotel(@PathVariable Long hotelId) {
        return ResponseEntity.ok(roomService.getRoomsByHotel(hotelId));
    }

    @GetMapping("/hotel/{hotelId}/available")
    public ResponseEntity<List<RoomResponseDto>> getAvailableRooms(
            @PathVariable Long hotelId,
            @RequestParam RoomType roomType) {
        return ResponseEntity.ok(roomService.getAvailableRooms(hotelId, roomType));
    }
}
