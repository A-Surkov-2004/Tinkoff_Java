package edu.hw8.Task2;

import java.util.concurrent.atomic.AtomicInteger;

public class FibNum {

    AtomicInteger last = new AtomicInteger(0);
    AtomicInteger current = new AtomicInteger(1);

    public void countNext() {
        int mem = current.get();
        current.addAndGet(last.get());
        last.set(mem);
    }

    public int getAnswer() {
        return current.get();
    }

}
