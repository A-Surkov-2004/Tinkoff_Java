package edu.hw5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Pattern;

public class Task5 {

    private final static Logger LOGGER = LogManager.getLogger();

    Task5(){}

    Boolean passwordValidation(String text){
        return Pattern.matches(".*[~!@#%^&*$|]+.*", text);
    }
}
