package com.pluralsight;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reservation {

    private Room room;
    private int numberOfNights;
    private boolean weekend;


    public double getPrice() {
        double rate = room.getPricePerNight();

        return weekend ? rate : rate * 1.5;
    }

    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}
