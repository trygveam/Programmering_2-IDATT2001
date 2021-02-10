package edu.ntnu.idatt2001.trygveam.frivillig1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    public static boolean isLeapYear(int year) throws IllegalArgumentException {
        if (year >= 0) {
            return (year % 4 == 0) &&
                    (year % 100 != 0) ||
                    (year % 400 == 0);
        } else {
            throw new IllegalArgumentException("Year must be larger than or equal to zero");
        }
    }

    public static long daysBetween(LocalDate startDate,
                                   LocalDate endDate, boolean includeEndDate) {
        long days = ChronoUnit.DAYS.between(startDate,
                endDate);
        if (includeEndDate) {
            if (days >= 0) { return days+1; }
            else { return days-1; }
        } else {
            return days;
        }
    }
}
