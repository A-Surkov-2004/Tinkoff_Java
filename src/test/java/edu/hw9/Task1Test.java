package edu.hw9;

import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Task1Test {
    @Test
    void test1() {
        for (int i = 0; i < 1; i++) {
            // given
            Task1 t1 = new Task1();
            Task1.StatsCollector collector = t1.new StatsCollector();

            Runnable task1 = () -> collector.push("a", new double[] {0.1, 0.05, 1.4, 5.1, 0.3});
            Runnable task2 = () -> collector.push("b", new double[] {3, 2, 1, 5, 4});
            Runnable task3 = () -> collector.push("c", new double[] {-8, 0, 0, 3, -1});
            Runnable task4 = () -> collector.push("c", new double[] {8, 0, 0, -3, 1});
            // when
            try (ExecutorService service = Executors.newFixedThreadPool(1)) {
                service.submit(task1);
                service.submit(task2);
                service.submit(task3);
                service.submit(task4);
            }
            Task1.StatsCollector.Stats ans1 = collector.stats("a");
            Task1.StatsCollector.Stats ans2 = collector.stats("c");

            // then
            assertThat(ans1.sum())
                .isCloseTo(6.95, offset(0.000000001));

            assertThat(ans2.armean())
                .isCloseTo(0, offset(0.000000001));

            assertThat(ans2.min())
                .isCloseTo(-8, offset(0.000000001));

            assertThat(ans2.max())
                .isCloseTo(8, offset(0.000000001));
        }
    }
}
