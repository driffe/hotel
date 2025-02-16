package com.example.demo.domain.hotel.dto;

import com.example.demo.domain.hotel.entity.Hotel;
import com.example.demo.domain.room.dto.RoomResponseDto;
import com.example.demo.domain.room.entity.Room;
import com.example.demo.domain.room.entity.RoomType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class HotelResponseDto {
    private String name;
    private String address;
    private String description;
    private Long id;


    @Builder
    private HotelResponseDto (Long id, String name, String address, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public static HotelResponseDto of(Hotel hotel) {
        return HotelResponseDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .address(hotel.getAddress())
                .description(hotel.getDescription())
                .build();
    }
}

