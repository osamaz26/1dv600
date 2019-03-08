package oz222am_hangman.Models.Players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PlayerTest {
    private Player sut = new Player();

    @Test
    public void shouldSetValue() throws Exception {
        String input = "otherName";

        sut.setName(input);
        assertEquals(sut.getName(), input);
    }


    @Test
    public void shouldThrowException() {
        String input = "";

       assertThrows(Exception.class,
                ()-> sut.setName(input));
    }


    @Test
    public void shouldReturnValue() throws Exception {
        String input = "otherName";
        String expected = input;
        sut.setName(input); //setup sut

        assertEquals(sut.getName(), expected);
    }

    @Test
    public void shouldReturnString() throws Exception {
        String input = "otherName";
        String expected = "[0] Player: " + input;
        sut.setName(input); //setup sut


        assertEquals(sut.toString(), expected);
    }
}
