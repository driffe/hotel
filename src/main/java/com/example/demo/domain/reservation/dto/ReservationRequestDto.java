package com.example.demo.domain.reservation.dto;

import com.example.demo.domain.room.entity.RoomType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequestDto {
    private Long hotelId;
    private RoomType roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
