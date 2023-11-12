package edu.hw5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;



public class Task3 {

    private final static Logger LOGGER = LogManager.getLogger();

    Task3(){}

    Optional<LocalDate> parseDate(String string){
        String[] splited;
        switch (string){
            case "today":
                return Optional.of(LocalDate.now());
            case "tomorrow":
                return Optional.of(LocalDate.now().plusDays(1));
            case "yesterday":
                return Optional.of(LocalDate.now().minusDays(1));
            default:
                break;
        }

        splited = string.split(" ");
        if(splited.length == 3){
            int minus = Integer.parseInt(splited[0]);
            return  Optional.of(LocalDate.now().minusDays(minus));
        }

        LocalDate ld;
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sf.parse(string);
            ld = LocalDate.ofInstant(d.toInstant(), ZoneId.of("UTC"));
            ld = ld.plusDays(1);
            return Optional.of(ld);
        } catch (ParseException e){}

        try {
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
            Date d = sf.parse(string);
            ld = LocalDate.ofInstant(d.toInstant(), ZoneId.of("UTC"));
            ld = ld.plusDays(1);
            if (ld.getYear() < 1000){
                ld = ld.plusYears(2000).plusDays(2);
            }
            return Optional.of(ld);
        } catch (ParseException e){}
        return Optional.empty();
    }
}
