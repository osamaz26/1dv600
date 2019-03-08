package oz222am_hangman.Models.Words;

import oz222am_hangman.Models.Model;

/**
 * The type Word.
 */
public class Word extends Model {
    private String value;

    /**
     * Instantiates a new Word.
     */
    public Word() {

    }

    private boolean validateValue(String word) {
        if (word.isEmpty()) {
            return false;
        }
        for (int i = 0; i < word.length(); ++i) {
            if (!Character.isLetter(word.charAt(i))
            ) {
                return false;
            }
        }
        return true;
    }


    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     * @throws Exception the exception
     */
    public void setValue(String value) throws Exception {
        if (!validateValue(value)) {
            throw new Exception("invalid word");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("[%d] Word: %s", getId(), value);
    }
}
