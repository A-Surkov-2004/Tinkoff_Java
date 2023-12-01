package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Worker {

    private final static Logger LOGGER = LogManager.getLogger();
    private BufferedReader in;
    private BufferedWriter out;

    public Worker(Socket socket) {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            LOGGER.trace(e);
        }
        work();
    }

    private String work() {
        List<String> ans;
        String answer = "";
        try {
            LOGGER.info("Сервер подключил клиента");

            LOGGER.info("Сервер: Жду запрос");
            String word = in.readLine();
            LOGGER.info("Сервер: Принял запрос");

            LOGGER.info(word);

            List<String> data = new Data().getData();

            ans = data.stream().filter(phrase -> phrase.split(word).length > 1).toList();

            if (!ans.isEmpty()) {
                answer = ans.get(0);
            } else {
                answer = "Ничего не найдено(";
            }
            out.write(answer);
            out.flush();

        } catch (Exception e) {
            LOGGER.trace(e);
        }
        LOGGER.info("Сервер: Ответил, конец сессии");
        return answer;
    }
}
