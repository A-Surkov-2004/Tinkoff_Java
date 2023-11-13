package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {

    private static final int NUMBER_OF_MONTHS = 12;
    private static final int  BAKERS_DOZEN = 13;
    private final static Logger LOGGER = LogManager.getLogger();

    Task2() {

    }

    List<String> fridays13InYear(int year) {

        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= NUMBER_OF_MONTHS; i++) {
            LocalDate d = LocalDate.of(year, i, BAKERS_DOZEN);
            if (d.getDayOfWeek() == DayOfWeek.FRIDAY) {
                ans.add(d.toString());
            }
        }
        return ans;
    }

    String closestFriday13(Date date) {
        LocalDate d = LocalDate.ofInstant(date.toInstant(), ZoneId.of("UTC"));
        while (d.getDayOfMonth() != BAKERS_DOZEN || d.getDayOfWeek() != DayOfWeek.FRIDAY) {
            d = d.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return d.toString();
    }
}
