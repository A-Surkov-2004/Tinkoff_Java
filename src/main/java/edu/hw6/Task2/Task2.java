package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {

    private final static Logger LOGGER = LogManager.getLogger();

    public void makeCopy(Path p) {
        String[] splited = p.toString().split(".txt")[0].split(" — копи");
        int number = 0;
        if (splited.length > 1) {
            number++;
            Pattern pattern = Pattern.compile("\\(\\d+\\)");
            Matcher matcher = pattern.matcher(splited[1]);

            while (matcher.find()) {
                number = Integer.parseInt(splited[1].substring(matcher.start() + 1, matcher.end() - 1));
            }
        }
        StringBuilder newPathString = new StringBuilder(splited[0]);
        newPathString.append(" — копия");
        if (number != 0) {
            newPathString.append(" (").append(number + 1).append(")");
        }
        Path newPath = Path.of(newPathString.toString());
        try {
            Files.copy(p, newPath);
        } catch (IOException e) {
            makeCopy(newPath);
        }
    }
}
