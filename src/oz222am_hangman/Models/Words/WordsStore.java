package oz222am_hangman.Models.Words;

import oz222am_hangman.Models.Store;

import java.util.ArrayList;
import java.util.List;

public class WordsStore extends Store<Word> {


    public WordsStore(String path) {
        super(path);
    }

    public List<Word> read() throws Exception {
        List<Word> items = new ArrayList<>();
        return items;
    }
}
