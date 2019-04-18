package oz222am_hangman.Models.Players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * The type Player test.
 */
public class PlayerTest {
    private Player sut = new Player();

    /**
     * Should set value.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldSetValue() throws Exception {
        String input = "otherName";

        sut.setName(input);
        assertEquals(sut.getName(), input);
    }


    /**
     * Should throw exception.
     */
    @Test
    public void shouldThrowException() {
        String input = "";

        assertThrows(Exception.class,
                () -> sut.setName(input));
    }


    /**
     * Should return value.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldReturnValue() throws Exception {
        String input = "otherName";
        String expected = input;
        sut.setName(input); //setup sut

        assertEquals(sut.getName(), expected);
    }

    /**
     * Should return string.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldReturnString() throws Exception {
        String input = "otherName";
        String expected = "[0] Player: " + input + ", wins: 0, loses: 0";
        sut.setId(0);
        sut.setName(input); //setup sut


        assertEquals(sut.toString(), expected);
    }

    @Test
    public void shouldSetNumberOfWins() throws Exception {
        String input = "otherName";
        var expected = 50;
        sut.setNumberOfWins(50);
        sut.setName(input); //setup sut


        assertEquals(sut.getNumberOfWins(), expected);

        sut.addWin();

        assertEquals(sut.getNumberOfWins(), expected + 1);
    }

    @Test
    public void shouldSetNumberOfLoses() throws Exception {
        String input = "otherName";
        var expected = 50;
        sut.setNumberOfLoses(50);
        sut.setName(input); //setup sut


        assertEquals(sut.getNumberOfLoses(), expected);

        sut.addLose();

        assertEquals(sut.getNumberOfLoses(), expected + 1);
    }
}
