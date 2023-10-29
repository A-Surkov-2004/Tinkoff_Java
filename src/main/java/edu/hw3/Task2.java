package edu.hw3;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {
    Task2() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public ArrayList<String> clusterize(String str) {
        StringBuilder element = new StringBuilder();
        ArrayList<String> ans = new ArrayList<String>();
        int opened = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                opened++;
            } else {
                opened--;
            }
            element.append(ch);
            if (opened == 0) {
                ans.add(element.toString());
                element = new StringBuilder();
            }
        }
        return ans;
    }

}
