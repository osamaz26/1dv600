package oz222am_hangman.Models.Words;

import oz222am_hangman.Models.Items;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Random;

public class Words extends Items<Word> {
    Random random = new Random();

    public Words() {
        super();
    }

    public Words(String path) {
        super();
        setPath(path);
    }

    @Override
    public void load() throws Exception {
        var bufferedReader = new BufferedReader(new FileReader(getPath()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            add(line);
        }
        bufferedReader.close();
    }

    @Override
    public void save() throws Exception {
        var bufferedWriter = new BufferedWriter(new FileWriter(getPath()));
        for (Word word : getValues()) {
            bufferedWriter.write(word.getValue() + "\n");
        }
        bufferedWriter.close();
    }

    public Word add(String value) throws Exception {
        var word = new Word();
        word.setValue(value);
        return super.add(word);
    }

    public Word pick() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty list");
        }
        return (Word) getValues().toArray()[random.nextInt(getSize())];
    }

    public List<Word> get() {
        return null;
    }
}
