package oz222am_hangman.Models.Games;

import oz222am_hangman.Models.Words.Word;

/**
 * The type Game.
 */
public class Game {
    private Word word;
    private char[] chars;
    private int failedTries = 0;
    private int totalTires = 0;


    /**
     * Instantiates a new Game.
     *
     * @param word the word
     */
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

    /**
     * Verify boolean.
     *
     * @param c the c
     * @return the boolean
     */
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

    /**
     * Display string.
     *
     * @return the string
     */
    public String display() {
        StringBuilder result = new StringBuilder();
        for (var character : chars) {
            result.append(character).append(" ");
        }
        return result.toString();
    }

    /**
     * Is solved boolean.
     *
     * @return the boolean
     */
    public boolean isSolved() {
        return String.valueOf(chars).equals(word.getValue());
    }

    /**
     * Gets failed tries.
     *
     * @return the failed tries
     */
    public int getFailedTries() {
        return failedTries;
    }

    /**
     * Gets total tires.
     *
     * @return the total tires
     */
    public int getTotalTires() {
        return totalTires;
    }
}
