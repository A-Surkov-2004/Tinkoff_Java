package edu.hw3;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {
    Task3() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public Map<String, Integer> freqDict(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String i : strings) {
            map.merge(i, 1, Integer::sum);
        }
        return map;
    }
}
