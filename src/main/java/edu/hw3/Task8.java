package edu.hw3;

import java.util.Collection;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task8 {
    private final static Logger LOGGER = LogManager.getLogger();

    Task8() {
    }

    public static class BackwardIterator implements Iterator<Object> {

        private final Collection<Object> given;
        private int i;

        public BackwardIterator(Collection<Object> given) {
            this.given = given;
            this.i = given.size();
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Object next() {
            Object[] r = given.toArray();
            return r[i-- - 1];
        }
    }
}
