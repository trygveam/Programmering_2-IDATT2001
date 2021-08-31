package edu.ntnu.idatt2001.trygveam.oblig3;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    private static Hand hand;

    @BeforeAll
    static void init(){
        PlayingCard p1 = new PlayingCard('S',4);
        PlayingCard p2 = new PlayingCard('D',7);
        PlayingCard p3 = new PlayingCard('H',1);
        PlayingCard p4 = new PlayingCard('H',7);
        PlayingCard p5 = new PlayingCard('C',12);
        hand = new Hand(new ArrayList<PlayingCard>(Arrays.asList(p1,p2,p3,p4,p5)));


    }

    @Nested
    class testWithCorrectArguments{

        @Test
        @DisplayName("Test that checks correct sum of cards")
        public void sumCards_listWithCards_CorrectSumReturned(){
            assertEquals(31,hand.sumCards());
        }

        @Test
        @DisplayName("Test that checks if hearts is present")
        public void checkIfContainsHearts_listWithCards_ShouldReturnCardsWithHeart(){
            assertEquals("H1 H7", hand.checkIfContainsHearts());
        }
        @Test
        @DisplayName("Test that check if Queen of spades is present")
        public void checkIfQueenSpadesPresent_listWithCards_ShouldReturnNoIfNotInList(){
            assertEquals("NO", hand.checkIfQueenSpadesPresent());
        }

        @Test
        @DisplayName("Test that checks if a flush is present")
        public void checkForFlush_listWithCards_ShouldReturnNoIfNotInList(){
            assertEquals("NO", hand.checkForFlush());
        }
    }
    @Nested
    class testWithFalseArguments{
        @Test
        @DisplayName("Test that checks if constructor throws exception when the arraylist is empty")
        public void constructor_emptyArrayListGiven_ThrowingException(){
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Hand(new ArrayList<PlayingCard>());
            });

        }
    }

}