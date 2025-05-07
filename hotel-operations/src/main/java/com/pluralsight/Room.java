package com.pluralsight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public void checkIn() {
        if (!isAvailable())
            throw new IllegalStateException("Room is not available");
        occupied = true;
        dirty = true;
    }

    public void checkout() {
        if (isAvailable())
            throw new IllegalStateException("Room is not occupied");

        occupied = false;
        dirty = true;
    }

    public void clean() {
        if (isAvailable())
            throw new IllegalStateException("Room is not dirty");
        dirty = false;
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
