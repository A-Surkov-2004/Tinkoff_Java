package edu.hw3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {

    private final static Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("ключ null")
    void test1() {


        // given
        Task8 t8 = new Task8();
        Integer[] given = new Integer[] {1, 2, 3};
        StringBuilder ans = new StringBuilder();

        // when
        Task8.MyIterator mi = t8.new MyIterator(given);
        LOGGER.info(mi.hasNext());
        while (mi.hasNext()){
            ans.append(mi.next());
        }

        // then
        assertThat(ans.toString()).isEqualTo("321");
    }
}
