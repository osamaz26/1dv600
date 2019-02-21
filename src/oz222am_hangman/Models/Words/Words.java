package oz222am_hangman.Models.Words;

import oz222am_hangman.Models.Items;

import java.util.Random;

public class Words extends Items<Word> {
    public Words() {
        super();
    }

    public Words(String path) {
        super();
        setPath(path);
    }

    @Override
    public void load() throws Exception {

    }

    @Override
    public void save() throws Exception {

    }

    public Word add(String value) throws Exception {
        var word = new Word();
        word.setValue(value);
        return super.add(word);
    }

    public Word pick() {
        var random = new Random();
        //return (Word) getValues().toArray()[random.nextInt(getSize())];
        return null;
    }


}
