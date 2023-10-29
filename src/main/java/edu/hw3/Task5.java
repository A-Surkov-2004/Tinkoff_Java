package edu.hw3;

import java.util.Arrays;
import java.util.Objects;

public class Task5 {
    Task5() {
    }

    private static SepNames[] sort(SepNames[] sepNames, String method) {
        if (Objects.equals(method, "ASC")) {
            Arrays.sort(sepNames, (o1, o2) -> {
                if (Objects.equals(o1.surName, o2.surName)) {
                    return o1.name.compareTo(o2.name);
                } else {
                    return o1.surName.compareTo(o2.surName);
                }
            });
        } else if (Objects.equals(method, "DESC")) {
            Arrays.sort(sepNames, (o1, o2) -> {
                if (Objects.equals(o1.surName, o2.surName)) {
                    return o2.name.compareTo(o1.name);
                } else {
                    return o2.surName.compareTo(o1.surName);
                }
            });
        }
        return sepNames;
    }

    public String[] parseContacts(String[] fullNames, String method) {
        if (fullNames == null) {
            return new String[] {};
        }
        SepNames[] sepNames = new SepNames[fullNames.length];
        String[] currentSep;
        for (int i = 0; i < fullNames.length; i++) {
            currentSep = fullNames[i].split(" ");
            if (currentSep.length == 2) {
                sepNames[i] = new SepNames(currentSep[0], currentSep[1]);
            } else {
                sepNames[i] = new SepNames(currentSep[0], "");
            }
        }

        sort(sepNames, method);

        String[] sortedNames = new String[fullNames.length];
        for (int i = 0; i < fullNames.length; i++) {
            sortedNames[i] = sepNames[i].name;
            sortedNames[i] += !Objects.equals(sepNames[i].surName, "") ? " " + sepNames[i].surName : "";
        }
        return sortedNames;
    }

    public record SepNames(String name, String surName) {
    }
}
