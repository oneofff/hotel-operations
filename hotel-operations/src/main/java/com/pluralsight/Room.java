package com.pluralsight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Room {

    private int numberOfBeds;
    private double pricePerNight;
    private boolean occupied;
    private boolean dirty;
    private RoomType roomType;

    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    public void setRoomType(String roomType) {
        this.roomType = RoomType.valueOf(roomType.toUpperCase());
    }

    @Getter
    public enum RoomType {
        KING(139.00, "King"),
        DOUBLE(124.00, "Double");

        private final double pricePerNight;
        private final String name;

        RoomType(double v, String name) {
            this.pricePerNight = v;
            this.name = name;
        }

    }
}
