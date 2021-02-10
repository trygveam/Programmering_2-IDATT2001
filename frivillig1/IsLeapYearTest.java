package edu.ntnu.idatt2001.trygveam.frivillig1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsLeapYearTest {
    @Nested
    class AYearIsALeapYear {

        @Test
        @DisplayName("Year is divisible by 100 but not by 400")
        public void yearIsDivisibleByFourButNotByOneHundred() {
            assertTrue(DateUtils.isLeapYear(2020));
        }

        @Test
        public void yearIsDivisibleByFourHundred() {
            assertTrue(DateUtils.isLeapYear(2000));
        }
    }

    @Nested
    class AYearIsNotALeapYear {

        @Test
        public void yearIsNotDivisibleByFour() {
            assertFalse(DateUtils.isLeapYear(1981));
        }

        @Test
        public void yearIsDivisibleByOneHundredButNotByFourHundred() {
            assertFalse(DateUtils.isLeapYear(2100));
        }
    }

    @Nested
    class AYearIsNotSupported {

        @Test
        public void yearIsNegative() {
            try {
                DateUtils.isLeapYear(-1);
            } catch (IllegalArgumentException ex) {
                assertEquals(ex.getMessage(), "Year must be larger than or equal to zero");
            }
            // Or we could do this:
            // assertThrows(IllegalArgumentException.class, () -> DateUtils.isLeapYear(-1));
        }
    }
}
