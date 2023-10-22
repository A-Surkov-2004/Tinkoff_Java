package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {

    private final static int ERROR = 404;
    private final static String EXECUTED = "Executed";
    private final static Logger LOGGER = LogManager.getLogger();

    public interface Connection extends AutoCloseable {
        String execute(String command);
    }

    public interface ConnectionManager {

        Connection STABLE_CONNECTION = new Connection() {

            @Override
            public String execute(String command) {
                return EXECUTED;
            }

            @Override
            public void close() throws Exception {
                return;
            }
        };

        Connection FAULTY_CONNECTION = new Connection() {
            @Override
            public String execute(String command) throws ConnectionException {
                boolean[] state = new boolean[] {true, false};
                boolean ok = state[(int) (Math.random() * 2)];
                if (ok) {
                    return EXECUTED;
                }
                throw new ConnectionException(ERROR, "Ошибка подключения");

            }

            @Override
            public void close() throws Exception {
                return;
            }

        };

        Connection getConnection();

        public record FaultyConnectionManager() implements ConnectionManager {
            @Override
            public Connection getConnection() {
                return FAULTY_CONNECTION;
            }
        }

        public record DefaultConnectionManage() implements ConnectionManager {
            @Override
            public Connection getConnection() {
                boolean[] state = new boolean[] {true, false};
                boolean ok = state[(int) (Math.random() * 2)];
                if (ok) {
                    return STABLE_CONNECTION;
                }
                return FAULTY_CONNECTION;
            }
        }
    }

    public static class ConnectionException extends RuntimeException {
        public ConnectionException(int i, String error) {
        }
    }

    public final class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        public void updatePackages() throws Exception {
            tryExecute("apt update && apt upgrade -y");
        }

        int attempts = 1;

        void tryExecute(String command) throws Exception {
            Connection con = manager.getConnection();
            try {
                con.execute(command);
            } catch (ConnectionException e) {
                LOGGER.info(" " + e + " " + attempts);
                if (attempts >= maxAttempts) {
                    throw e;
                }
                attempts++;
                tryExecute(command);
            }
            con.close();
        }
    }
}
