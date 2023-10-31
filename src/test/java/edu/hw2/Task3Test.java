package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.hw2.Task3.Task3;
import edu.hw2.Task3.ConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;

public class Task3Test {
    private final static Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("Стандартный")
    void test1() throws Exception {
        PopularCommandExecutor executor =
            new PopularCommandExecutor(new ConnectionManager.DefaultConnectionManage(), 5);
        try {
            executor.tryExecute("cmd");
        } catch (Task3.ConnectionException e) {
            LOGGER.info("Поймано исключение!");
        }
    }

    @Test
    @DisplayName("Проблемный")
    void test2() throws Exception {
        Task3 t = new Task3();
        PopularCommandExecutor executor =
            new PopularCommandExecutor(new ConnectionManager.FaultyConnectionManager(), 5);
        try {
            executor.tryExecute("cmd");
        } catch (Task3.ConnectionException e) {
            LOGGER.info("Поймано исключение!");
        }
    }

    @Test
    @DisplayName("Проблемный+ (no retry)")
    void test3() throws Exception {
        PopularCommandExecutor executor =
            new PopularCommandExecutor(new ConnectionManager.FaultyConnectionManager(), 0);
        try {
            executor.tryExecute("cmd");
        } catch (Task3.ConnectionException e) {
            LOGGER.info("Поймано исключение!");
        }
    }

    @Test
    @DisplayName("Проблемный 100x")
    void test4() throws Exception {
        PopularCommandExecutor executor =
            new PopularCommandExecutor(new ConnectionManager.FaultyConnectionManager(), 5);
        try {
            for (int i = 0; i < 100; i++) {
                executor.tryExecute("cmd");
            }
        } catch (Task3.ConnectionException e) {
            LOGGER.info("Поймано исключение!");
        }
    }
}
