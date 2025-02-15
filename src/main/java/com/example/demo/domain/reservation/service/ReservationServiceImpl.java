package com.example.demo.domain.reservation.service;

import com.example.demo.domain.hotel.repository.HotelRepository;
import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.repository.MemberRepository;
import com.example.demo.domain.reservation.dto.ReservationRequestDto;
import com.example.demo.domain.reservation.entity.Reservation;
import com.example.demo.domain.reservation.repository.ReservationRepository;
import com.example.demo.domain.room.entity.Room;
import com.example.demo.domain.room.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
    private final MemberRepository memberRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    @Override
    @Transactional
    public Long createReservation(String username, ReservationRequestDto dto) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        Room room = roomRepository.findByHotelIdAndTypeAndStatus(
                        dto.getHotelId(), dto.getRoomType(), true)
                .orElseThrow(() -> new RuntimeException("예약 가능한 객실이 없습니다."));

        room.updateStatus(false);  // 방 상태 업데이트

        Reservation reservation = Reservation.of(
                member,
                room,
                dto.getCheckInDate(),
                dto.getCheckOutDate()
        );

        return reservationRepository.save(reservation).getId();
    }

    @Override
    @Transactional
    public void cancelReservation(String username, Long reservationId) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() ->new RuntimeException("존재하지 않는 회원입니다."));

        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 예약"));

        validateReservationOwner(member, reservation);

        Room room = reservation.getRoom();
        room.updateStatus(true);  // 방 상태를 다시 예약 가능으로 변경

        reservationRepository.delete(reservation);
    }

    @Override
    public List<Reservation> getReservationsByMember(String username) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        return reservationRepository.findByMember(member);
    }

    private void validateReservationOwner(Member member, Reservation reservation) {
        if (!member.equals(reservation.getMember())) {
            throw new RuntimeException("오너 확인");
        }
    }
}
