package edu.hw5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Task1 {

    private final static Logger LOGGER = LogManager.getLogger();

    public String sessionTime(String[] strings){

        if (strings == null || strings.length == 0){
            return "0с";
        }

        Instant d = new Date(0).toInstant();
        Duration global = Duration.between(d, d);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd,HH:mm");

        for (String time : strings) {
            String[] times = time.split(" - ");
            try {
                Date t1 = sf.parse(times[0]);
                Date t2 = sf.parse(times[1]);
                Duration duration = Duration.between(t1.toInstant(), t2.toInstant());
                global = global.plus(duration);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String ans = global.dividedBy(strings.length).toString();
        ans = ans.replace("H", "ч ")
            .replace("M", "м")
            .replace("S", "с")
            .replace("PT","");
        LOGGER.info(ans);
        return ans;
    }
}
