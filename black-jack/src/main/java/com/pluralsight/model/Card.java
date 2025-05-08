package com.pluralsight.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
public class Card {

    private final Suit suit;
    private final Ranks rank;

    @Override
    public String toString() {
        return rank.displayName + " " + suit.symbol;
    }

    @Getter
    @RequiredArgsConstructor
    @ToString
    public enum Suit {
        HEARTS("Hearts", "♠"),
        SPADES("Spades", "♥"),
        DIAMONDS("Diamonds", "♦"),
        CLUBS("Clubs", "♣");

        private final String displayName;
        private final String symbol;
    }

    @Getter
    @RequiredArgsConstructor
    @ToString
    public enum Ranks {
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("J", 10),
        QUEEN("Q", 10),
        KING("K", 10),
        ACE("A", 11);

        private final String displayName;
        private final int value;
    }
}
