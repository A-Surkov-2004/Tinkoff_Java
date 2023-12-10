package edu.hw9.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Printer {

    private static final String BLACK = "\u001B[40m";
    private static final String LIGHTBLUE = "\u001B[46m";
    private static final String BLUE = "\u001B[44m";
    private static final String WHITE = "\u001B[47m";
    private static final String WIDE = "   ";

    private final static Logger LOGGER = LogManager.getLogger();

    public void printMap(char[][] map) {

        StringBuilder string = new StringBuilder();
        string.append('\n');
        for (char[] i : map) {
            for (char j : i) {
                if (j == Generator.BLANK) {
                    string.append(WHITE);
                } else if (j == Generator.SPACE) {
                    string.append(BLACK);
                } else if (j == Generator.EXIT) {
                    string.append(LIGHTBLUE);
                } else if (j == Solver.PATH) {
                    string.append(LIGHTBLUE);
                } else if (j == Solver.TRUEPATH) {
                    string.append(BLUE);
                }
                string.append(WIDE);
            }
            string.append(BLACK);
            string.append(System.lineSeparator());
        }
        LOGGER.info(string);
    }

}
