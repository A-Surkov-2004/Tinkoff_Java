package edu.hw8.Task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server {

    private final static Logger LOGGER = LogManager.getLogger();
    public static int users = 0;
    private static final int PORT = 4004;
    private static final int THREADS = 3;
    private Boolean opened = false;

    public Server() {

    }

    public void run() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            Callable<String> task1 = () -> f(server);
            ExecutorService service = Executors.newFixedThreadPool(THREADS);
            opened = true;
            while (opened) {
                service.submit(task1);
            }
            service.shutdown();
        } catch (IOException e) {
            LOGGER.trace(e);
        }
    }

    public boolean getCondition() {
        return opened;
    }

    public void close() {
        try {
            LOGGER.info("Сервер закрывается");
            opened = false;
        } catch (Exception e) {
            LOGGER.trace(e);
        }
    }

    private String f(ServerSocket server) throws IOException {

        while (users >= THREADS){

        }
        Socket socket = server.accept();
        users++;
        LOGGER.info("Сервер подключает клиента");
        new Worker(socket);
        users--;
        return "";
    }

}
