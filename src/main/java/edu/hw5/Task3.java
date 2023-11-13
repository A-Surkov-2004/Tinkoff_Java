package edu.hw5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {

    private static final int WORDS_TO_PARSE = 3;
    private static final int SHORT_FORMAT_BORDER = 1000;
    private static final int SHORT_FORMAT_EXTENSION = 2000;
    private static final String UTC = "UTC";
    private final static Logger LOGGER = LogManager.getLogger();

    Task3() {
    }

    @SuppressWarnings("ReturnCount")
    Optional<LocalDate> parseDate(String string) {
        String[] splited;
        switch (string) {
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
        if (splited.length == WORDS_TO_PARSE) {
            int minus = Integer.parseInt(splited[0]);
            return Optional.of(LocalDate.now().minusDays(minus));
        }

        LocalDate ld;
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sf.parse(string);
            ld = LocalDate.ofInstant(d.toInstant(), ZoneId.of(UTC));
            ld = ld.plusDays(1);
            return Optional.of(ld);
        } catch (ParseException e) {
        }

        try {
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
            Date d = sf.parse(string);
            ld = LocalDate.ofInstant(d.toInstant(), ZoneId.of(UTC));
            ld = ld.plusDays(1);
            if (ld.getYear() < SHORT_FORMAT_BORDER) {
                ld = ld.plusYears(SHORT_FORMAT_EXTENSION).plusDays(2);
            }
            return Optional.of(ld);
        } catch (ParseException e) {
        }
        return Optional.empty();
    }
}
