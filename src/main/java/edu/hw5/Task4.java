package edu.hw5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Task4 {

    private final static Logger LOGGER = LogManager.getLogger();

    Task4(){}

    Boolean passwordValidation(String text){
        return Pattern.matches(".*[~!@#%^&*$|]+.*", text);
    }
}
