package com.pluralsight.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public int getPoints() {
        int sum = 0;
        for (var c : cards) {
            sum += c.getRank().getValue();

        }
        if (sum > 21 && cards.contains(Card.Ranks.ACE))
            sum -= 10;
        return sum;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean isBust() { return getPoints() > 21; }

    @Override
    public String toString() {
        return cards.toString();

    }
}
