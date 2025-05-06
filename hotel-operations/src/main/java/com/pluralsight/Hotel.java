package com.pluralsight;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Hotel {
    private final String name;
    private final int numberOfSuites;
    private final int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicsRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicsRooms = 0;
    }

    public boolean bookRoom(int numberBookingRooms, boolean isSuite){
        return isSuite ? bookSuites(numberBookingRooms) : bookBasicRooms(numberBookingRooms);
    }

    private boolean bookBasicRooms(int numberBookingRooms) {
        boolean isAvailable = numberOfRooms > bookedBasicsRooms + numberBookingRooms;
        if (isAvailable)
            bookedBasicsRooms += numberBookingRooms;

        return isAvailable;
    }

    private boolean bookSuites(int numberBookingRooms) {
        boolean isAvailable = numberOfSuites > bookedSuites + numberBookingRooms;
        if (isAvailable)
            bookedSuites += numberBookingRooms;

        return isAvailable;
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicsRooms;
    }

    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }
}
