package com.example.demo.domain.reservation.dto;

import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.reservation.entity.Reservation;
import com.example.demo.domain.room.entity.RoomType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationResponseDto {
    private Long id;
    private Long hotelId;
    private String hotelName;
    private RoomType roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @Builder
    private ReservationResponseDto(Long id, Long hotelId, String hotelName,
                                   RoomType roomType, LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = id;
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public static ReservationResponseDto of(Reservation reservation) {
        return ReservationResponseDto.builder()
                .id(reservation.getId())
                .hotelId(reservation.getRoom().getHotel().getId())
                .hotelName(reservation.getRoom().getHotel().getName())
                .roomType(reservation.getRoom().getType())
                .checkInDate(reservation.getCheckInDate())
                .checkOutDate(reservation.getCheckOutDate())
                .build();
    }
}

