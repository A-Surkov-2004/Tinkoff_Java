package edu.hw5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task2 {

    private final static Logger LOGGER = LogManager.getLogger();

    Task2(){

    }

    List<String> fridays13InYear(int year){

        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            LocalDate d = LocalDate.of(year, i, 13);
            if(d.getDayOfWeek() == DayOfWeek.FRIDAY){
                ans.add(d.toString());
            }
        }
        return ans;
    }

    String ClosestFriday13(Date date){
        LocalDate d = LocalDate.ofInstant(date.toInstant(), ZoneId.of("UTC"));
        while (d.getDayOfMonth() != 13 || d.getDayOfWeek() != DayOfWeek.FRIDAY) {
            d = d.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return d.toString();
    }
}
