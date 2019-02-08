package oz222am_hangman.Models.Words;

import oz222am_hangman.Models.BaseModel;

public class Word extends BaseModel {
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
