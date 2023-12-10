package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {

    Task4() {
    }

    Boolean passwordValidation(String text) {
        return Pattern.matches(".*[~!@#%^&*$|]+.*", text);
    }
}
