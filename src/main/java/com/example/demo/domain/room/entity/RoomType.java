package com.example.demo.domain.room.entity;

public enum RoomType {
    SINGLE("Single"),
    DOUBLE("Double"),
    DELUXE("Deluxe");

    private final String type;

    RoomType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
