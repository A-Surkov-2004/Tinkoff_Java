package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Task1 {
    private Task1() {
    }

    static private final int SECONDS_IN_MINUTE = 60;

    private final static Logger LOGGER = LogManager.getLogger();

    public static int minutesToSeconds(String time) {

        int minutes;
        int seconds;

        if(time.length() >=5){
        String [] timeSep = time.split(":");
        minutes = Integer.parseInt(timeSep[0]);
        seconds = Integer.parseInt(timeSep[1]);
        } else {
            return -1;
        }

        if (seconds < SECONDS_IN_MINUTE && seconds > -1) {
            int ans = minutes * SECONDS_IN_MINUTE + seconds;
            LOGGER.info(ans);
            return ans;
        } else {
            return -1;
        }
    }
}
