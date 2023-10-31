package edu.hw3.Task5;

public class Task5 {
    public Task5() {
    }

    public Contacts[] parseContacts(String[] fullNames, String method) {
        if (fullNames == null) {
            return new Contacts[] {};
        }
        Contacts[] contacts = new Contacts[fullNames.length];
        String[] currentSep;
        for (int i = 0; i < fullNames.length; i++) {
            currentSep = fullNames[i].split(" ");
            if (currentSep.length == 2) {
                contacts[i] = new Contacts(currentSep[0], currentSep[1]);
            } else {
                contacts[i] = new Contacts(currentSep[0], "");
            }
        }
        return Sort.sort(contacts, method);
    }

    public record Contacts(String name, String surName) {
        public String getName() {
            return name;
        }

        String getSurName() {
            return surName;
        }
    }
}
