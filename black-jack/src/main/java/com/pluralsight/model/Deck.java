package com.pluralsight.model;

import lombok.Data;

import java.security.SecureRandom;
import java.util.*;

@Data
public class Deck {
    private Queue<Card> cards;

    public Deck() {
        this.cards = new ArrayDeque<>(36);
        for (var s : Card.Suit.values()) {
            for (var r : Card.Ranks.values()) {
                cards.add(new Card(s, r));
            }
        }
    }

    public void shuffle() {
        List<Card> list = new ArrayList<>(cards);

        Collections.shuffle(list, new SecureRandom());
        this.cards = new ArrayDeque<>(list);
    }

    public Card deal() {
        return cards.poll();
    }
}
