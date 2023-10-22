package edu.project1;

public class Session {
    public int maxAttempts;
    public String word;

    Session(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        word = getWord();
    }

    public String getWord() {
        String[] words = new String[] {"Тинькофф", "Тетриандох", "Аксолотль", "Навохудоноссор"};
        return words[(int) (Math.random() * words.length)];
    }
}
