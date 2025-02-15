package com.example.demo.domain.reservation.entity;

import com.example.demo.domain.auditing.entity.BaseTimeEntity;
import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.room.entity.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@SuperBuilder
@Table(name = "reservation")
public class Reservation extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public static Reservation of(Member member, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        return Reservation.builder()
                .member(member)
                .room(room)
                .checkInDate(checkInDate)
                .checkOutDate(checkOutDate)
                .build();
    }
}
