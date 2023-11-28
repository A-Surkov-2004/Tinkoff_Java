package edu.hw7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    private final static Logger LOGGER = LogManager.getLogger();

    @Test
    void test1() {
        // given
        for(int i = 0; i < 1000; i++) {
            Task3 t3 = new Task3();
            Task3.Database database = t3.new Database();

            Task3.Person p1 = new Task3.Person(1,"Sherlock","221B Baker Street", "020-7224-3688");
            Task3.Person p2 = new Task3.Person(2,"Pushkin","Moika River embankment, 12", "+7-812");
            Task3.Person p3 = new Task3.Person(3,"Victor","St. Petersburg, Veterans Avenue, 99", "+7 (921) 856-16-79");
            Task3.Person p4 = new Task3.Person(4,"Michael","Moscow, Bolshaya Sadovaya, 302 bis, fifth floor, sq. No. 50", "+7 (968) 894-19-60");


            Task3.Person[] result1 = new Task3.Person[1];
            Task3.Person[] result2 = new Task3.Person[1];
            Task3.Person[] result3 = new Task3.Person[1];

            // when

            Thread th1 = new Thread(() -> {
                database.add(p1);
                database.add(p2);
                database.add(p3);
                database.add(p4);
            });

            Thread th2 = new Thread(() -> {
                List<Task3.Person> localResults = database.findByAddress("221B Baker Street");
                if (!localResults.isEmpty()) {
                    result1[0] = localResults.get(0);
                }
            });

            Thread th22 = new Thread(() -> {
                List<Task3.Person> localResults = database.findByName("Pushkin");
                if (!localResults.isEmpty()) {
                    result2[0] = localResults.get(0);
                }
            });

            Thread th23 = new Thread(() -> {
                List<Task3.Person> localResults = database.findByPhone("+7 (968) 894-19-60");
                if (!localResults.isEmpty()) {
                    result3[0] = localResults.get(0);
                }
            });

            Thread th3 = new Thread(() -> {
                database.delete(1);
                database.delete(2);
                database.delete(3);
                database.delete(4);
            });

            th1.start();
            th2.start();
            th22.start();
            th23.start();
            th3.start();
            try {
                th1.join();
                th2.join();
                th22.join();
                th23.join();
                th3.join();
            } catch (InterruptedException e) {
                LOGGER.info(e);
            }

            // then

            if (result1[0] == p1){
                //LOGGER.info("a");
                assertThat(result1[0].name())
                    .isEqualTo("Sherlock");
                assertThat(result1[0].phoneNumber())
                    .isEqualTo("020-7224-3688");
            } else {
                assertThat(result1[0]).isEqualTo(null);
            }

            if (result2[0] == p2){
                //LOGGER.info("b");
                assertThat(result2[0].address())
                    .isEqualTo("Moika River embankment, 12");
                assertThat(result2[0].phoneNumber())
                    .isEqualTo("+7-812");
            } else {
                assertThat(result2[0]).isEqualTo(null);
            }

            if (result3[0] == p4){
                //LOGGER.info("c");
                assertThat(result3[0].name())
                    .isEqualTo("Michael");
                assertThat(result3[0].address())
                    .isEqualTo("Moscow, Bolshaya Sadovaya, 302 bis, fifth floor, sq. No. 50");
            } else {
                assertThat(result3[0]).isEqualTo(null);
            }
        }
    }
}
