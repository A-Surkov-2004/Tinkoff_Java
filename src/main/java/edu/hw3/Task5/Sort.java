package edu.hw3.Task5;

import java.util.Arrays;
import java.util.Objects;

public class Sort {
    private Sort() {
    }

    static Task5.Contacts[] sort(Task5.Contacts[] contacts, String method) {
        if (Objects.equals(method, "ASC")) {
            Arrays.sort(contacts, (o1, o2) -> {
                if (Objects.equals(o1.getSurName(), o2.getSurName())) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return o1.getSurName().compareTo(o2.getSurName());
                }
            });
        } else if (Objects.equals(method, "DESC")) {
            Arrays.sort(contacts, (o1, o2) -> {
                if (Objects.equals(o1.getSurName(), o2.getSurName())) {
                    return o2.getName().compareTo(o1.getName());
                } else {
                    return o2.getSurName().compareTo(o1.getSurName());
                }
            });
        }
        return contacts;
    }
}
