package com.pluralsight.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private Hand hand;

    @Override
    public String toString() {
        return name + ": " + hand + " "+ hand.getPoints();
    }
}
