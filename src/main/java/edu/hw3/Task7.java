package edu.hw3;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Task7 {
    Task7() {
    }

    public class Tree {

        Map<String, String> map = new TreeMap<>(Comparator.nullsFirst(new MyComparator()));

        Tree() {
        }

        void add(String key, String s) {
            map.put(key, s);
        }

        static class MyComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }
    }
}
