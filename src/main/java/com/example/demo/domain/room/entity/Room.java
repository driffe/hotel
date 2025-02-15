package com.example.demo.domain.room.entity;

import com.example.demo.domain.auditing.entity.BaseTimeEntity;
import com.example.demo.domain.hotel.entity.Hotel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "room")

public class Room extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomType type;

    private int price;

    private boolean status = true; // true: 예약 가능, false: 예약 불가

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public static Room of(Hotel hotel, RoomType type, int price) {
        return Room.builder()
                .hotel(hotel)
                .type(type)
                .price(price)
                .status(true)
                .build();
    }

    public void updateStatus(boolean status) {
        this.status = status;
    }
}
