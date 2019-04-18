package oz222am_hangman.Models.Words;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * The type Word test.
 */
public class WordTest {
    private Word sut = new Word();

    /**
     * Should set value.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldSetValue() throws Exception {
        String input = "otherName";

        sut.setValue(input);
        assertEquals(sut.getValue(), input);
    }


    /**
     * Should throw exception.
     */
    @Test
    public void shouldThrowException() {
        String input = "";

       assertThrows(Exception.class,
                ()-> sut.setValue(input));
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
        sut.setValue(input); //setup sut

        assertEquals(sut.getValue(), expected);
    }

    /**
     * Should return string.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldReturnString() throws Exception {
        String input = "otherName";
        String expected = "[0] Word: " + input;
        sut.setValue(input); //setup sut


        assertEquals(sut.toString(), expected);
    }
}
