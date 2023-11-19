package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Diskmap {

    private final static String PATH = "src\\main\\java\\edu\\hw6\\Task1\\SavedMap.txt";
    private final static Logger LOGGER = LogManager.getLogger();

    public Diskmap(Map<String, String> map) {
        saveMap(map);
    }

    public void saveMap(Map<String, String> map) {
        Path p = Path.of(PATH);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(p.toFile()))) {

            for (String i : map.keySet()) {
                writer.write(i + ":" + map.get(i) + "\n");
            }
        } catch (Exception e) {
            LOGGER.catching(e);
        }
    }

    public Map<String, String> loadMap() {
        Path p = Path.of(PATH);
        Map<String, String> map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(p.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splited = line.split(":");
                map.put(splited[0], splited[1]);
            }
        } catch (Exception e) {
            LOGGER.catching(e);
        }
        return map;
    }
}
