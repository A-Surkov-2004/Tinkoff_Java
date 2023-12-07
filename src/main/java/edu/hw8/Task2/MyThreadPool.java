package edu.hw8.Task2;

import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThreadPool implements ThreadPool {

    public MyThreadPool() {

    }

    private final static Logger LOGGER = LogManager.getLogger();
    private Thread[] thList;
    private LinkedBlockingQueue<Runnable> q = new LinkedBlockingQueue<>();

    @Override
    public void start() {
        while (!q.isEmpty()) {
            for (Thread thread : thList) {
                thread.run();
            }
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            q.put(runnable);
        } catch (InterruptedException e) {
            LOGGER.trace(e);
        }
    }

    public void create(int nThreads) {
        thList = new Thread[nThreads];
        for (int i = 0; i < nThreads; i++) {
            thList[i] = new Thread(() -> {
                while (!q.isEmpty()) {
                    Objects.requireNonNull(q.poll()).run();
                }
            });
        }

    }

    @Override
    public void close() throws Exception {
        for (Thread thread : thList) {
            if (thread.isAlive()) {
                thread.join();
            }
        }
    }
}
