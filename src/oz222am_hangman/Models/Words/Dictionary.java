package oz222am_hangman.Models.Words;

import oz222am_hangman.Models.BaseModelItems;

import java.util.Random;

public class Dictionary extends BaseModelItems<Word> {

    Dictionary() {
        super();
    }

    @Override
    public void read(String path) throws Exception {
        var store = new WordsStore(path);
        add(store.read());
    }

    public Word add(String value) throws Exception {
        var word = new Word();
        word.setValue(value);
        return super.add(word);
    }

    public Word pick() {
        var random = new Random();
        return (Word) getValues().toArray()[random.nextInt(getSize())];
    }


}
