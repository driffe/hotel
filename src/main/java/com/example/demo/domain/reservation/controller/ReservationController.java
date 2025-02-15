package com.example.demo.domain.reservation.controller;

import com.example.demo.domain.reservation.dto.ReservationRequestDto;
import com.example.demo.domain.reservation.entity.Reservation;
import com.example.demo.domain.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Long> createReservation(
            @RequestParam String username,
            @RequestBody @Valid ReservationRequestDto request) {
        return ResponseEntity.ok(reservationService.createReservation(username, request));
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> cancelReservation(
            @RequestParam String username,
            @PathVariable Long reservationId) {
        reservationService.cancelReservation(username, reservationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/my")
    public ResponseEntity<List<Reservation>> getMyReservations(
            @RequestParam String username) {
        return ResponseEntity.ok(reservationService.getReservationsByMember(username));
    }
}
