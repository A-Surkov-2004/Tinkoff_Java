package edu.project2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Printer {

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String WIDE = "   ";

    private final static Logger LOGGER = LogManager.getLogger();

    void printMap(char[][] map) {
        StringBuilder string = new StringBuilder();
        string.append('\n');
        for (char[] i : map) {
            for (char j : i) {
                if (j == Generator.BLANK) {
                    string.append(ANSI_WHITE_BACKGROUND);
                    string.append(WIDE);
                } else if (j == Generator.SPACE) {
                    string.append(ANSI_BLACK_BACKGROUND);
                    string.append(WIDE);
                } else if (j == Generator.EXIT) {
                    string.append(ANSI_RED_BACKGROUND);
                    string.append(WIDE);
                } else if (j == Solver.PATH) {
                    string.append(ANSI_RED_BACKGROUND);
                    string.append(WIDE);
                }
            }
            string.append(ANSI_BLACK_BACKGROUND);
            string.append('\n');
        }
        LOGGER.info(string.toString());
    }

}
