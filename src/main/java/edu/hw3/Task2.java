package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    Task2() {
    }

    public List<String> clusterize(String str) {
        if (str == null) {
            return new ArrayList<>();
        }
        StringBuilder element = new StringBuilder();
        List<String> ans = new ArrayList<>();
        int opened = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                opened++;
            } else if (ch == ')') {
                opened--;
            }
            element.append(ch);
            if (opened == 0) {
                ans.add(element.toString());
                element = new StringBuilder();
            }
        }
        if (opened == 0) {
            return ans;
        } else {
            return List.of("");
        }
    }

}
