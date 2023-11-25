package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {

    private final static Logger LOGGER = LogManager.getLogger();

    public Task1() {

    }

    public int counter(int n) {

        AtomicInteger count = new AtomicInteger(0);

        for (int i = 0; i < n; i++) {
            Thread counter1 = new Thread(() -> {
                count.getAndIncrement();
            });
            Thread counter2 = new Thread(() -> {
                count.getAndIncrement();
            });
            counter1.start();
            counter2.start();
            try {
                counter1.join();
                counter2.join();
            } catch (InterruptedException e) {
                LOGGER.catching(e);
            }

        }
        return count.get();
    }
}
