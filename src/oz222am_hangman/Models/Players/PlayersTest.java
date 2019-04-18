package oz222am_hangman.Models.Players;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PlayersTest {
    String basePath = "E:\\Courses\\LNU-61004\\01\\1DV600\\Project\\src\\oz222am_hangman\\resources/";


    @Test
    void shouldLoad() {
        var players = new Players();
        players.setPath(this.basePath + "no_found_path.txt");
        assertThrows(Exception.class, players::load);

        players.setPath(this.basePath + "players_ill_formatted_0.txt");
        assertThrows(Exception.class, players::load);

        players.setPath(this.basePath + "players_ill_formatted_1.txt");
        assertThrows(Exception.class, players::load);

        players.setPath(this.basePath + "players_ill_formatted_2.txt");
        assertThrows(Exception.class, players::load);

        players.setPath(this.basePath + "players_load_test.txt");
        assertDoesNotThrow(players::load);

        assertEquals(2, players.getSize());
    }

    @Test
    void shouldSave() {
        var players = new Players(this.basePath + "players_save_test.txt");

        assertDoesNotThrow(() -> {
            players.register("new");
        });

        assertDoesNotThrow(() -> {
            players.register("new2");
        });
        assertEquals(2, players.getSize());

        assertDoesNotThrow(players::save);


    }

    @Test
    void shouldRegister() {
        var players = new Players();
        assertThrows(Exception.class, () -> players.register(""));
        assertDoesNotThrow(() -> {
            players.register("new");
        });
    }

    @Test
    void shouldBeFound() {
        var players = new Players();
        assertDoesNotThrow(() -> {
            players.register("new");
        });

        assertDoesNotThrow(() -> {
            players.register("new2");
        });

        assertNull(players.findByName("another"));
        assertNotNull(players.findByName("new"));

    }
}
