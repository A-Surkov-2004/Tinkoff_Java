package edu.hw2;

import edu.hw2.Task3.Task3;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {
    private final static Logger LOGGER = LogManager.getLogger();

    public CallingInfo catcher() {
        try {
            f();
        } catch (Throwable e) {
            StackTraceElement[] stktrace = e.getStackTrace();
            LOGGER.info(stktrace[0]);
            String[] half = stktrace[0].toString().split("\\(");
            String[] words = half[0].split("\\.");
            return new CallingInfo(words[words.length - 2], words[words.length - 1]);
        }
        return null;
    }

    public void f() {
        throw new Task3.ConnectionException(-1, "Ошибка 1");
    }

    public record CallingInfo(String className, String methodName) {}

}
