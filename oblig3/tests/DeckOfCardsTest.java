package edu.ntnu.idatt2001.trygveam.oblig3;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {


    private static DeckOfCards d;

    @BeforeAll
    static void init(){
        d = new DeckOfCards();
    }
    @Test
    @DisplayName("Test that checks correct amount of cards in deck")
    public void getCards_listWithCardsGiven_ExpectedCorrectSize(){
        assertEquals(52, d.getCards().size());
    }

    @Test
    @DisplayName("Test that checks if correct number of cards is dealt")
    public void dealHand_positiveNumberGiven_ShouldDealCorrectNumberOfCards(){
        ArrayList<PlayingCard> boo = (ArrayList<PlayingCard>) d.dealHand(5);
        assertEquals(5,boo.size());
    }

    @Test
    @DisplayName("Test that checks if exception is thrown if argument is <0")
    public void dealHand_NegativeNumbergiven_ExceptionThrown(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            d.dealHand(-1);
        });
    }

}