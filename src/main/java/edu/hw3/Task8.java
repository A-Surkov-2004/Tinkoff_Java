package edu.hw3;

import java.util.Iterator;

public class Task8 {
    Task8() {
    }

    public class MyIterator implements Iterator<Integer> {

        private final Integer[] given;
        private int i;

        public MyIterator(Integer[] given) {
            this.given = given;
            this.i = given.length;
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Integer next() {
            return given[i-- - 1];
        }
    }
}
