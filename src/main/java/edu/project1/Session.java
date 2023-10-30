package edu.project1;

public class Session {
    private final int maxAttempts;
    private final String word;

    Session(int maxAttempts, String[] words) {
        this.maxAttempts = maxAttempts;
        word = getNewWord(words);
    }

    public String getNewWord(String[] words) {
        return words[(int) (Math.random() * words.length)];
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public String getWord() {
        return word;
    }
}
