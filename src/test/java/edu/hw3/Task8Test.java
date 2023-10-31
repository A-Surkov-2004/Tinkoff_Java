package edu.hw3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {

    private final static Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("Числа")
    void test1() {
        // given
        Collection<Object> given = new ArrayList<>();
        given.add(1);
        given.add(2);
        given.add(3);
        ArrayList<Object> ans = new ArrayList<>();

        // when
        Task8.BackwardIterator mi = new Task8.BackwardIterator(given);
        LOGGER.info(given);
        while (mi.hasNext()){
            ans.add(mi.next());
        }

        // then
        assertThat(ans.toString()).isEqualTo("[3, 2, 1]");
    }

    @Test
    @DisplayName("Строки")
    void test2() {
        // given
        Collection<Object> given = new ArrayList<>();
        given.add("1");
        given.add("2");
        given.add("ten");
        ArrayList<Object> ans = new ArrayList<>();

        // when
        Task8.BackwardIterator mi = new Task8.BackwardIterator(given);
        LOGGER.info(given);
        while (mi.hasNext()){
            ans.add(mi.next());
        }

        // then
        assertThat(ans.toString()).isEqualTo("[ten, 2, 1]");
    }

    @Test
    @DisplayName("Сет")
    void test3() {
        // given
        Collection<Object> given = new HashSet<>();
        given.add("1");
        given.add("2");
        given.add("ten");
        ArrayList<Object> ans = new ArrayList<>();

        // when
        Task8.BackwardIterator mi = new Task8.BackwardIterator(given);
        LOGGER.info(given);
        while (mi.hasNext()){
            ans.add(mi.next());
        }

        // then
        assertThat(ans.toString()).isEqualTo("[ten, 2, 1]");
    }

    @Test
    @DisplayName("Очередь")
    void test4() {
        // given
        Collection<Object> given = new LinkedList<>();
        given.add("1");
        given.add(4.2);
        given.add("ten");
        ArrayList<Object> ans = new ArrayList<>();

        // when
        Task8.BackwardIterator mi = new Task8.BackwardIterator(given);
        LOGGER.info(given);
        while (mi.hasNext()){
            ans.add(mi.next());
        }

        // then
        assertThat(ans.toString()).isEqualTo("[ten, 4.2, 1]");
    }
}
