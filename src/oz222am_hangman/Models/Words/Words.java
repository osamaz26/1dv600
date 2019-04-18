package oz222am_hangman.Models.Words;

import oz222am_hangman.Models.Items;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

/**
 * The type Words.
 */
public class Words extends Items<Word> {
    /**
     * The Random.
     */
    Random random = new Random();

    /**
     * Instantiates a new Words.
     */
    public Words() {
        super();
    }

    /**
     * Instantiates a new Words.
     *
     * @param path the path
     */
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

    /**
     * Add word.
     *
     * @param value the value
     * @return the word
     * @throws Exception the exception
     */
    public Word add(String value) throws Exception {
        var word = new Word();
        word.setValue(value);
        return super.add(word);
    }

    /**
     * Pick word.
     *
     * @return the word
     * @throws Exception the exception
     */
    public Word pick() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty list");
        }
        return (Word) getValues().toArray()[random.nextInt(getSize())];
    }
}
