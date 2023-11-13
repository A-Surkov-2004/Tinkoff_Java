package edu.hw5;

import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task5 {

    private final static Logger LOGGER = LogManager.getLogger();

    Task5() {
    }

    Boolean carPlateValidation(String text) {
        return Pattern.matches("[А-Я]\\d{3}[А-Я]{2}\\d{3}", text);
    }
}
