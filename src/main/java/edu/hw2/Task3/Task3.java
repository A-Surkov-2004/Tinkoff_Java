package edu.hw2.Task3;

public class Task3 {

    public interface Connection extends AutoCloseable {
        String execute(String command);
    }

    public static class ConnectionException extends RuntimeException {
        public ConnectionException(int i, String error) {
        }
    }

}
