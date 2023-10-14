package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Task1 {
    private Task1() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(String time) {

        int minutes;
        int seconds;

        minutes = Integer.parseInt(time.split(":")[0]);
        seconds = Integer.parseInt(time.split(":")[1]);

        if (seconds < 60 && seconds > -1) {
            int ans = minutes * 60 + seconds;
            LOGGER.info(ans);
            return ans;
        } else {
            return -1;
        }
    }
}
