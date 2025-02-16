package com.example.demo.domain.reservation.service;

import com.example.demo.domain.reservation.dto.ReservationRequestDto;
import com.example.demo.domain.reservation.dto.ReservationResponseDto;
import com.example.demo.domain.reservation.entity.Reservation;

import java.util.List;

public interface ReservationService {
    Long createReservation(String username, ReservationRequestDto dto);
    void cancelReservation(String username, Long reservationId);
    List<ReservationResponseDto> getReservationsByMember(String username);

}
