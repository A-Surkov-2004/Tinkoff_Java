package edu.hw3;

import java.util.TreeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {
    private final TreeMap<Integer, String> map;
    private final static Logger LOGGER = LogManager.getLogger();

    Task4() {
        this.map = getMap();
    }

    @SuppressWarnings("MagicNumber")
    TreeMap<Integer, String> getMap() {
        TreeMap<Integer, String> rims = new TreeMap<>();
        rims.put(1000, "M");
        rims.put(900, "CM");
        rims.put(500, "D");
        rims.put(400, "CD");
        rims.put(100, "C");
        rims.put(90, "XC");
        rims.put(50, "L");
        rims.put(40, "XL");
        rims.put(10, "X");
        rims.put(9, "IX");
        rims.put(5, "V");
        rims.put(4, "IV");
        rims.put(1, "I");
        return rims;
    }

    String convertToRoman(int sum) {

        int part = map.floorKey(sum);
        LOGGER.trace("Сумма: {}", sum);
        LOGGER.trace("Вычитаем: {}", part);
        if (sum == part) {
            return map.get(sum);
        }
        return map.get(part) + convertToRoman(sum - part);
    }
}
