package com.example.demo.domain.room.dto;

import com.example.demo.domain.room.entity.Room;
import com.example.demo.domain.room.entity.RoomType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomResponseDto {
    private Long id;
    private RoomType type;
    private int price;
    private boolean status;
    private Long hotelId;

    @Builder
    private RoomResponseDto(Long id, RoomType type, int price, boolean status, Long hotelId) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.status = status;
        this.hotelId = hotelId;
    }

    public static RoomResponseDto of(Room room) {
        return RoomResponseDto.builder()
                .id(room.getId())
                .type(room.getType())
                .price(room.getPrice())
                .status(room.isStatus())
                .hotelId(room.getHotel().getId())
                .build();
    }
}
