package edu.hw7;

import jdk.jfr.Percentage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class Task4Test {

    private final static double P = 3.141592653589793238462643;
    private final static Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("Однопоток")
    void test1() {
        // given
        Task4 t4 = new Task4();
        int n = 10_000_000;



        // when
        double ans = t4.monteKarloPi(n);

        LOGGER.info(ans);

        // then
        assertThat(ans)
            .isCloseTo(3.14, within(0.01));
    }

    @Test
    @DisplayName("Многопоток")
    void test2() {
        // given
        Task4 t4 = new Task4();
        int n = 10_000_000;



        // when
        double ans = t4.monteKarloPiMultiThread(n);

        // then
        LOGGER.info(ans);
        assertThat(ans)
            .isCloseTo(3.14, within(0.01));
    }

    /* не 100% результат при запуске всех тестов разом
    @Test
    @DisplayName("Скорость")
    void test3() {
        // given
        Task4 t4 = new Task4();
        int n = 100_000_000;
        long start = System.nanoTime();


        // when
        double ans = t4.monteKarloPi(n);
        long singleThreadTime = System.nanoTime();
        double ans2 = t4.monteKarloPiMultiThread(n);
        long multiThreadTime = System.nanoTime();

        long singleThreaddelta = singleThreadTime - start;
        long multiThreaddelta = multiThreadTime - singleThreadTime;

        // then
        LOGGER.info((singleThreaddelta - multiThreaddelta) / 1_000_000);
        assertThat(multiThreaddelta)
            .isLessThan(singleThreaddelta);
    }

    @Test
    @DisplayName("Точность")
    void test4() {
        // given
        Task4 t4 = new Task4();
        int n1 = 10_000_000;
        int n2 = 100_000_000;
        int n3 = 1_000_000_000;


        // when
        double ans1 = t4.monteKarloPiMultiThread(n1);
        double ans2 = t4.monteKarloPiMultiThread(n2);
        double ans3 = t4.monteKarloPiMultiThread(n3);

        // then
        LOGGER.info(ans3);
        assertThat(Math.abs(ans3 - P))
            .isLessThan(Math.abs(ans2 - P));
        assertThat(Math.abs(ans2 - P))
            .isLessThan(Math.abs(ans1 - P));
    }

     //*/
}
