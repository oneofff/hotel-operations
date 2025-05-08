package com.pluralsight;

import com.pluralsight.model.Deck;
import com.pluralsight.model.Hand;
import com.pluralsight.model.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("How many players?");
        int amountOfPlayers = readInt(1, 8);
        List<Player> players = new ArrayList<>(amountOfPlayers);

        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.println("Name of the player " + (i + 1) + ":");
            String name = scanner.nextLine();
            Hand hand = new Hand();
            hand.addCard(deck.deal());
            hand.addCard(deck.deal());
            players.add(new Player(name, hand));
        }

        System.out.println();
        for (var p : players) {
            boolean agreed = true;
            while (agreed) {
                System.out.println("-".repeat(25));
                System.out.println(p);
                System.out.println(p.getName() + " hit? (1/0)");
                agreed = readInt(0, 1) == 1;
                if (agreed)
                    p.getHand().addCard(deck.deal());
                if (p.getHand().isBust()) {
                    System.out.println("You Busted!");
                    System.out.println(p);
                    break;
                }
            }
        }

        for (var p : players) {
            System.out.println(p);
        }
        System.out.println("-".repeat(25));

        Player winner = players.stream().filter(player -> !player.getHand().isBust())
                .max(Comparator.comparingInt(p -> p.getHand().getPoints())).orElse(null);
        if (winner == null)
            System.out.println("Tie! All Busted!!!");
        else
            System.out.println(winner.getName() + " won with the: " + winner.getHand());
    }


    private static int readInt(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(scanner.nextLine().trim());
                if (n >= min && n <= max) return n;
            } catch (NumberFormatException ignored) {
            }
            System.out.print("Enter a number (" + min + "‑" + max + "): ");
        }
    }

}