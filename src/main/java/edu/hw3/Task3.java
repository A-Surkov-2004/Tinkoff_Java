package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    Task3() {
    }

    public Map<String, Integer> freqDict(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String i : strings) {
            map.merge(i, 1, Integer::sum);
        }
        return map;
    }
}
