package oz222am_hangman.Models.Words;

import oz222am_hangman.Models.Model;

public class Word extends Model {
    private String value;

    public Word() {

    }

    private boolean validateValue(String word) {
        return true;
    }


    public String getValue() {
        return value;
    }

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
