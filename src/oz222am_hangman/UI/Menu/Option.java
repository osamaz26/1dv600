package oz222am_hangman.UI.Menu;

public enum Option {
    // Game
    GAME_START,
    GAME_PLAY,
    GAME_QUIT,

    // Players
    PLAYERS_REGISTER,
    PLAYERS_REMOVE,
    PLAYERS_LOGIN,

    // Words
    WORDS_ADD,
    WORDS_REMOVE,

    ;


    public static String toString(Option option) {
        switch (option) {
            case GAME_START:
                return "Start";
            case GAME_PLAY:
                return "Play";
            case GAME_QUIT:
                return "Quit";

            case PLAYERS_REGISTER:
                return "Register new player";
            case PLAYERS_REMOVE:
                return "remove player";

            case WORDS_ADD:
                return "Add new word";
            case WORDS_REMOVE:
                return "remove word";

            default:
                return "";
        }
    }

}
