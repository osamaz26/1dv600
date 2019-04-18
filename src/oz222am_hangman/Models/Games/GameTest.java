package oz222am_hangman.Models.Games;

import org.junit.jupiter.api.Test;
import oz222am_hangman.Models.Words.Word;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The type Game test.
 */
public class GameTest {


    /**
     * Should return true.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldReturnTrue() throws Exception {
        String input = "abc";
        var word = new Word();
        word.setValue(input);

        var game = new Game(word);
        assertTrue(game.verify('c'));
    }

    /**
     * Should display character.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldDisplayCharacter() throws Exception {
        String input = "abc";
        var word = new Word();
        word.setValue(input);

        var game = new Game(word);
        game.verify('c');

        assertEquals(game.display(), "_ _ c ");
    }


    /**
     * Should not solved.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldNotSolved() throws Exception {
        String input = "abc";
        var word = new Word();
        word.setValue(input);

        var game = new Game(word);
        game.verify('c');
        assertFalse(game.isSolved());
    }

    /**
     * Should return zero.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldReturnZero() throws Exception {
        String input = "abc";
        var word = new Word();
        word.setValue(input);

        var game = new Game(word);
        game.verify('c');
        assertEquals(game.getFailedTries(), 0);
    }

    /**
     * Should return total one.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldReturnTotalOne() throws Exception {
        String input = "abc";
        var word = new Word();
        word.setValue(input);

        var game = new Game(word);
        game.verify('c');
        assertEquals(game.getTotalTires(), 1);
    }

}
