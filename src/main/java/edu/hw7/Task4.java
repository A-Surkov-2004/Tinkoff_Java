package edu.hw7;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {

    private final static int R = 1;
    private final static int X = 1;
    private final static int Y = 1;
    private final static int THREAD_COUNT = 4;
    private final static int FOUR = 4;
    private final static Logger LOGGER = LogManager.getLogger();

    private AtomicInteger circleCount = new AtomicInteger(0);
    private AtomicInteger totalCount = new AtomicInteger(0);
    private int n;

    public Task4() {

    }

    public double monteKarloPi(int n) {

        int circleCount1 = 0;
        int totalCount1 = 0;

        for (int i = 0; i < n; i++) {
            double x = Math.random() * 2 * R;
            double y = Math.random() * 2 * R;

            if (Math.sqrt(Math.pow(x - X, 2) + Math.pow(y - Y, 2)) < R) {
                circleCount1++;
            }
            totalCount1++;
        }

        return FOUR * ((double) circleCount1 / totalCount1);
    }

    public double monteKarloPiMultiThread(int newn) {
        n = newn;
        n = n / THREAD_COUNT;

        circleCount = new AtomicInteger(0);
        totalCount = new AtomicInteger(0);

        Thread th1 = new Thread(this::runnable);
        Thread th2 = new Thread(this::runnable);
        Thread th3 = new Thread(this::runnable);
        Thread th4 = new Thread(this::runnable);

        th1.start();
        th2.start();
        th3.start();
        th4.start();

        try {
            th1.join();
            th2.join();
            th3.join();
            th4.join();
        } catch (InterruptedException e) {
            LOGGER.trace(e);
        }
        return FOUR * ((double) circleCount.get() / totalCount.get());
    }

    private void runnable() {
        for (int i = 0; i < n; i++) {

            double x = ThreadLocalRandom.current().nextDouble(2 * R);
            double y = ThreadLocalRandom.current().nextDouble(2 * R);

            if (Math.sqrt(Math.pow(x - X, 2) + Math.pow(y - Y, 2)) < R) {
                circleCount.getAndIncrement();
            }
            totalCount.getAndIncrement();
        }
    }
}
