package com.example.demo.domain.room.dto;

import com.example.demo.domain.room.entity.RoomType;
import lombok.Data;

@Data
public class RoomRequestDto {
    private RoomType type;
    private int price;
    private Long hotelId;
}
