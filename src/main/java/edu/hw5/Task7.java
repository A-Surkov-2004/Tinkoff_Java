package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task7 {

    private final static Logger LOGGER = LogManager.getLogger();

    Task7() {
    }

    Boolean twoThenZero(String text) {
        return Pattern.matches("[01]{2}0[01]*", text);
    }

    Boolean firstEqualsLast(String text) {
        Pattern pattern = Pattern.compile("^0[01]");
        Matcher matcher = pattern.matcher(text);
        LOGGER.info(matcher.find());

        return Pattern.matches("^0([0-1]*0)?$|^1([0-1]*1)?$", text);
    }

    Boolean oneToThree(String text) {
        return Pattern.matches("[01]{1,3}", text);
    }
}
