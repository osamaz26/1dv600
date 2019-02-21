package oz222am_hangman.Models.Games;

import oz222am_hangman.Models.Words.Word;

public class Game {
    private Word word;
    private char[] chars;
    private int failedTries = 0;
    private int totalTires = 0;


    public Game(Word word) {
        this.word = word;
        prepare();
    }

    private void prepare() {
        chars = new char[word.getValue().length()];
        for (int i = 0; i < chars.length; ++i) {
            chars[i] = '_';
        }
    }

    public boolean verify(char c) {
        ++totalTires;
        boolean result = false;
        var value = word.getValue();
        for (int i = 0; i < value.length(); ++i) {
            if (value.charAt(i) == c) {
                chars[i] = c;
                result = true;
            }
        }
        if (!result) {
            ++failedTries;
        }
        return result;

    }

    public String display() {
        StringBuilder result = new StringBuilder();
        for (var character : chars) {
            result.append(character).append(" ");
        }
        return result.toString();
    }

    public boolean isSolved() {
        return String.valueOf(chars).equals(word.getValue());
    }

    public int getFailedTries() {
        return failedTries;
    }

    public int getTotalTires() {
        return totalTires;
    }
}
