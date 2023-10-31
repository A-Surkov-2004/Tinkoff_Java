package edu.hw2.Task3;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;
    private final static Logger LOGGER = LogManager.getLogger();
    final static String EXECUTED = "Executed";

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    int attempts = 1;

    public void tryExecute(String command) throws Exception {
        //final Task3.Connection con = manager.getConnection();
        String s = "";
        while (!Objects.equals(s, EXECUTED)) {
            try (Task3.Connection con = manager.getConnection()) {
                s = con.execute(command);
            } catch (Task3.ConnectionException e) {
                LOGGER.trace("Попытка номер: {}", attempts);
                if (attempts >= maxAttempts) {
                    throw e;
                }
                attempts++;
            }
        }
    }
}
