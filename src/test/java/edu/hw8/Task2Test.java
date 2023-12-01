package edu.hw8;

import edu.hw8.Task2.FibNum;
import edu.hw8.Task2.MyThreadPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    private final static Logger LOGGER = LogManager.getLogger();

    @Test
    void test1() {
        //given
        FibNum f = new FibNum();
        int n = 25;
        int ans = 0;

        //when
        try (MyThreadPool threadPool = new MyThreadPool()) {
            threadPool.create(3);
            for (int i = 1; i < n; i++) {
                threadPool.execute(f::countNext);
            }
            threadPool.start();
            ans = f.getAnswer();
        } catch (Exception e) {
            LOGGER.trace(e);
        }

        //then
        assertThat(ans).isEqualTo(75025);
    }
}
