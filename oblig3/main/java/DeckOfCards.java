package edu.ntnu.idatt2001.trygveam.oblig3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * The type Deck of cards.
 *
 * @author trygveam
 */
public class DeckOfCards {

    private ArrayList<PlayingCard> cards;
    private final char[] suit = {'S', 'H', 'D', 'C'};

    /**
     * Instantiates a new Deck of cards.
     */
    public DeckOfCards() {
        cards = new ArrayList<>();
        for (char c : suit) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new PlayingCard(c, i));
            }
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
     * Deal hand collection.
     *
     * @param n the n
     * @return the collection
     */
    public Collection<PlayingCard> dealHand(int n) {
        if(n>0) {
            Random random = new Random();
            Collection<PlayingCard> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(cards.get(random.nextInt(cards.size())));
            }
            return temp;
        }
        else throw new IllegalArgumentException("number of cards cant be zero");
    }
}
