package oz222am_hangman.UI.Menu;

public enum Option {
    // Game
    GAME_START,
    GAME_PLAY,
    GAME_QUIT,

    // Players
    PLAYERS,
    PLAYERS_REGISTER,
    PLAYERS_REMOVE,
    PLAYERS_LOGIN,
    PLAYERS_LIST,

    // Words
    WORDS,
    WORDS_ADD,
    WORDS_REMOVE,
    WORDS_LIST,

    BACK;


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

            case WORDS:
                return "Words";
            case WORDS_ADD:
                return "Add new word";
            case WORDS_REMOVE:
                return "Remove word";
            case WORDS_LIST:
                return "List of words";

            case BACK:
                return "Back";
            default:
                return "";
        }
    }

}
