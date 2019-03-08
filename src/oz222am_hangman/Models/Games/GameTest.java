package oz222am_hangman.Models.Games;

import org.junit.jupiter.api.Test;
import oz222am_hangman.Models.Words.Word;

import static org.junit.jupiter.api.Assertions.*;


public class GameTest {


    @Test
    public void shouldReturnTrue() throws Exception {
        String input = "abc";
        var word = new Word();
        word.setValue(input);

        var game = new Game(word);
        assertTrue(game.verify('c'));
    }

    @Test
    public void shouldDisplayCharacter() throws Exception {
        String input = "abc";
        var word = new Word();
        word.setValue(input);

        var game = new Game(word);
        game.verify('c');

        assertEquals(game.display(), "_ _ c ");
    }


    @Test
    public void sholudNotSolved() throws Exception {
        String input = "abc";
        var word = new Word();
        word.setValue(input);

        var game = new Game(word);
        game.verify('c');
        assertFalse(game.isSolved());
    }

    @Test
    public void sholudReturnZero() throws Exception {
        String input = "abc";
        var word = new Word();
        word.setValue(input);

        var game = new Game(word);
        game.verify('c');
        assertEquals(game.getFailedTries(), 0);
    }

    @Test
    public void sholudReturnTotalOne() throws Exception {
        String input = "abc";
        var word = new Word();
        word.setValue(input);

        var game = new Game(word);
        game.verify('c');
        assertEquals(game.getTotalTires(), 1);
    }

}
