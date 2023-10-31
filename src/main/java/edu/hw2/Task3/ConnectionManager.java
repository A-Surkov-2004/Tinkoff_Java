package edu.hw2.Task3;

public interface ConnectionManager {

    int ERROR = 404;
    String EXECUTED = "Executed";
    Task3.Connection STABLE_CONNECTION = new Task3.Connection() {

        @Override
        public String execute(String command) {
            return EXECUTED;
        }

        @Override
        public void close() throws Exception {
            return;
        }
    };

    Task3.Connection FAULTY_CONNECTION = new Task3.Connection() {
        @Override
        public String execute(String command) throws Task3.ConnectionException {
            boolean[] state = new boolean[] {true, false};
            boolean ok = state[(int) (Math.random() * 2)];
            if (ok) {
                return EXECUTED;
            }
            throw new Task3.ConnectionException(ERROR, "Ошибка подключения");

        }

        @Override
        public void close() throws Exception {
            return;
        }

    };

    Task3.Connection getConnection();

    public record FaultyConnectionManager() implements ConnectionManager {
        @Override
        public Task3.Connection getConnection() {
            return FAULTY_CONNECTION;
        }
    }

    public record DefaultConnectionManage() implements ConnectionManager {
        @Override
        public Task3.Connection getConnection() {
            boolean[] state = new boolean[] {true, false};
            boolean ok = state[(int) (Math.random() * 2)];
            if (ok) {
                return STABLE_CONNECTION;
            }
            return FAULTY_CONNECTION;
        }
    }
}
