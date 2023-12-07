package edu.hw8;

import edu.hw8.Task1.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.hw8.Task1.Client;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    private final static Logger LOGGER = LogManager.getLogger();


    @Test
    void test1() throws ExecutionException, InterruptedException {
        // given
        Server server = new Server();
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        Client client4 = new Client();
        Client client5 = new Client();

        Thread runServerThread = new Thread(() -> {
            server.run();
        });

        Callable<String> task1 = () -> client1.run("интеллект");
        Callable<String> task2 = () -> client2.run("глупый");
        Callable<String> task3 = () -> client3.run("личности");
        Callable<String> task4 = () -> client4.run("оскорбления");
        Callable<String> task5 = () -> client5.run("пусто");

        String ans1 = "";
        String ans2 = "";
        String ans3 = "";
        String ans4 = "";
        String ans5 = "";

        //when
        runServerThread.start();
        boolean opened = false;
        while (!opened) {
            opened = server.getCondition();
            LOGGER.info("retry");
        };

        try (ExecutorService service = Executors.newFixedThreadPool(5)) {
            for (int i = 0; i < 1; i++) {
                Future<String> result1 = service.submit(task1);
                Future<String> result2 = service.submit(task2);
                Future<String> result3 = service.submit(task3);
                Future<String> result4 = service.submit(task4);
                Future<String> result5 = service.submit(task5);

                ans1 = result1.get();
                ans2 = result2.get();
                ans3 = result3.get();
                ans4 = result4.get();
                ans5 = result5.get();
            }
        }

        server.close();

        try {
            runServerThread.join();
        } catch (InterruptedException e) {
            LOGGER.catching(e);
        }

        //then
        assertThat(ans1).isEqualTo("Чем ниже интеллект, тем громче оскорбления");
        assertThat(ans2).isEqualTo("А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.");
        assertThat(ans3).isEqualTo("Не переходи на личности там, где их нет");
        assertThat(ans4).isEqualTo("Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами");
        assertThat(ans5).isEqualTo("Ничего не найдено(");
    }
}
