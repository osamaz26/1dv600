package oz222am_hangman.UI.Menu;

/**
 * The enum Option.
 */
public enum Option {
    /**
     * Game start option.
     */
// Game
    GAME_START,
    /**
     * Game play option.
     */
    GAME_PLAY,
    /**
     * Game quit option.
     */
    GAME_QUIT,

    /**
     * Players option.
     */
// Players
    PLAYERS,
    /**
     * Players register option.
     */
    PLAYERS_REGISTER,
    /**
     * Players remove option.
     */
    PLAYERS_REMOVE,
    /**
     * Players login option.
     */
    PLAYERS_LOGIN,
    /**
     * Players list option.
     */
    PLAYERS_LIST,

    /**
     * Words option.
     */
// Words
    WORDS,
    /**
     * Words add option.
     */
    WORDS_ADD,
    /**
     * Words remove option.
     */
    WORDS_REMOVE,
    /**
     * Words list option.
     */
    WORDS_LIST,

    /**
     * Yes option.
     */
    YES,
    /**
     * No option.
     */
    NO,

    /**
     * Back option.
     */
    BACK;


    /**
     * To string string.
     *
     * @param option the option
     * @return the string
     */
    public static String toString(Option option) {
        switch (option) {
            case GAME_START:
                return "Start";
            case GAME_PLAY:
                return "Play";
            case GAME_QUIT:
                return "Quit";

            case PLAYERS:
                return "Players";
            case PLAYERS_REGISTER:
                return "Register new player";
            case PLAYERS_REMOVE:
                return "Remove player";
            case PLAYERS_LIST:
                return "List of players";
            case PLAYERS_LOGIN:
                return "Login";

            case WORDS:
                return "Words";
            case WORDS_ADD:
                return "Add new word";
            case WORDS_REMOVE:
                return "Remove word";
            case WORDS_LIST:
                return "List of words";


            case YES:
                return "Yes";

            case NO:
                return "No";

            case BACK:
                return "Back";
            default:
                return "";
        }
    }

}
