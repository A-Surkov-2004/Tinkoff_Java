package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Task0 {
    private Task0() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void helloWorld(String[] args) {
        LOGGER.info("Привет, мир!");
    }
}
