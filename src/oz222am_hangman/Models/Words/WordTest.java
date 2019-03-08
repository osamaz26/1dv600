package oz222am_hangman.Models.Words;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class WordTest {
    private Word sut = new Word();

    @Test
    public void shouldSetValue() throws Exception {
        String input = "otherName";

        sut.setValue(input);
        assertEquals(sut.getValue(), input);
    }


    @Test
    public void shouldThrowException() {
        String input = "";

       assertThrows(Exception.class,
                ()-> sut.setValue(input));
    }


    @Test
    public void shouldReturnValue() throws Exception {
        String input = "otherName";
        String expected = input;
        sut.setValue(input); //setup sut

        assertEquals(sut.getValue(), expected);
    }

    @Test
    public void shouldReturnString() throws Exception {
        String input = "otherName";
        String expected = "[0] Word: " + input;
        sut.setValue(input); //setup sut


        assertEquals(sut.toString(), expected);
    }
}
