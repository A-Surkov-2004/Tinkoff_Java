package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {

    private static final int PORT = 4004;
    private final static Logger LOGGER = LogManager.getLogger();
    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;

    public Client() {

    }

    public String run(String str) {
        String serverWord = null;
        try {
            try {
                while (clientSocket == null) {
                    clientSocket = new Socket("localhost", PORT);
                }
                LOGGER.info("клиент подключается");

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                out.write(str + "\n");
                LOGGER.info("Клиент отправил запрос");
                out.flush();
                LOGGER.info("Клиент: ждёт ответа");
                serverWord = in.readLine();
                LOGGER.info("Ответ получен");
                LOGGER.info(serverWord);
            } finally {
                LOGGER.info("Клиент закрыт");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return serverWord;
    }
}
