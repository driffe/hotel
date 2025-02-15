package com.example.demo.domain.hotel.entity;

import com.example.demo.domain.auditing.entity.BaseTimeEntity;
import com.example.demo.domain.hotel.dto.HotelRequestDTO;
import com.example.demo.domain.room.entity.Room;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "hotel")
public class Hotel extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column
    private String description;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

    @Builder
    private Hotel(String name, String address, String description, String phone) {
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public static Hotel of(HotelRequestDTO dto) {
        return Hotel.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .description(dto.getDescription())
                .build();
    }

    public void update(HotelRequestDTO dto) {
    }
}
