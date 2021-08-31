package edu.ntnu.idatt2001.trygveam.oblig3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Hand.
 *
 * @author trygveam
 */
public class Hand {
    private ArrayList<PlayingCard> cards;

    /**
     * Instantiates a new Hand.
     *
     * @param cards the cards
     */
    public Hand(ArrayList<PlayingCard> cards) {
        if (cards.isEmpty()) {
            throw new IllegalArgumentException("cant be empty or null");
        } else {
            this.cards = cards;
        }
    }

    /**
     * Gets cards.
     *
     * @return the cards
     */
    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    /**
     * Sum cards int.
     *
     * @return the int
     */
    public int sumCards() {
        return cards.stream().mapToInt(PlayingCard::getFace).sum();
    }

    /**
     * Check if contains hearts string.
     *
     * @return the string
     */
    public String checkIfContainsHearts() {
        ArrayList<PlayingCard> temp = cards.stream().filter(p -> p.getSuit() == 'H').collect(Collectors.toCollection(ArrayList::new));
        return temp.size() == 0 ? "No hearts" : temp.stream().map(PlayingCard::toString).collect(Collectors.joining(" "));
    }

    /**
     * Check if queen spades is present, returns /yes or no string.
     *
     * @return the string
     */
    public String checkIfQueenSpadesPresent() {
        return cards.stream().anyMatch(p -> p.getSuit() == 'S' && p.getFace() == 1) ? "YES" : "NO";
    }

    /**
     * Check for flush in cards, returns string /yes or no.
     *
     * @return the string
     */
    public String checkForFlush() {
        List<Character> sortedCards = cards.stream().map(p -> p.getSuit()).sorted().collect(Collectors.toList());
        return sortedCards.get(0) == sortedCards.get(sortedCards.size() - 1) ? "YES" : "NO";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlayingCard pc : cards) {
            sb.append(pc.toString()).append("  ");
        }
        return sb.toString();
    }
}
