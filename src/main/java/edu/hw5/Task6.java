package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {

    Task6() {
    }

    Boolean isSubstring(String sub, String string) {
        StringBuilder reg = new StringBuilder(".*");
        for (int i = 0; i < sub.length(); i++) {
            reg.append(sub.charAt(i));
            reg.append(".*");
        }
        return Pattern.matches(reg.toString(), string);
    }
}
