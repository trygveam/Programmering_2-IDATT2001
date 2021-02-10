package edu.ntnu.idatt2001.trygveam.frivillig1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DaysBetweenTest {

    @Test
    public void negativeDaysReturnedIfEndDateBeforeStartDate(){
        LocalDate start = LocalDate.of(2021, 1, 8);
        LocalDate end = LocalDate.of(2021, 1, 6);
        assertEquals(-2,DateUtils.daysBetween(start,end, false));
    }

    @Test
    public void correctDaysReturnedWithIncludeEndDateFalse(){
        LocalDate start = LocalDate.of(2021, 1, 8);
        LocalDate end = LocalDate.of(2021, 1, 24);
        assertEquals(16, DateUtils.daysBetween(start,end,false));
    }
    @Test
    public void correctDaysReturnedWithIncludeEndDateTrue(){
        LocalDate start = LocalDate.of(2021, 1, 8);
        LocalDate end = LocalDate.of(2021, 1, 24);
        assertEquals(17, DateUtils.daysBetween(start,end,true));
    }

}
