package oz222am_hangman;


import oz222am_hangman.Models.Games.Game;
import oz222am_hangman.Models.Players.Player;
import oz222am_hangman.Models.Players.Players;
import oz222am_hangman.Models.Words.Words;
import oz222am_hangman.UI.HangmanImage;
import oz222am_hangman.UI.Layouts.ConfirmationLayout;
import oz222am_hangman.UI.Layouts.Game.GameLayout;
import oz222am_hangman.UI.Layouts.HomeLayout;
import oz222am_hangman.UI.Layouts.LoginPlayerLayout;
import oz222am_hangman.UI.Layouts.Players.PlayersAddLayout;
import oz222am_hangman.UI.Layouts.Players.PlayersLayout;
import oz222am_hangman.UI.Layouts.Players.PlayersRemoveLayout;
import oz222am_hangman.UI.Layouts.Words.WordsAddLayout;
import oz222am_hangman.UI.Layouts.Words.WordsLayout;
import oz222am_hangman.UI.Layouts.Words.WordsRemoveLayout;
import oz222am_hangman.UI.View;

/**
 * The type Hangman.
 */
public class Hangman {
    private View view;
    private Words words;
    private Players players;
    private Player currentPlayer;

    /**
     * Instantiates a new Hangman.
     *
     * @param view the view
     */
    public Hangman(View view) {
        this.view = view;
    }

    /**
     * Start.
     *
     * @param wordsPath   the words path
     * @param playersPath the players path
     */
    void start(String wordsPath, String playersPath) {
        if (!loadWords(wordsPath)) {
            return;
        }

        if (!loadPlayers(playersPath)) {
            return;
        }

        var layout = new HomeLayout(view);
        while (true) {
            view.print("# What would you like to do " + getCurrentPlayerName());
            var menuItem = layout.getMenuItem();
            switch (menuItem.getOption()) {
                case GAME_QUIT: {
                    if (confirm()) {
                        return;
                    }
                    break;
                }
                case GAME_START: {
                    startGame();
                    break;
                }
                case PLAYERS: {
                    startPlayers();
                    break;
                }
                case WORDS: {
                    startWords();
                    break;
                }
                case PLAYERS_LOGIN: {
                    loginPlayer();
                    break;
                }
            }
        }
    }

    private String getCurrentPlayerName() {
        if (currentPlayer == null) {
            return null;
        }
        return " (" + currentPlayer.getName() + ")";
    }

    private boolean loadWords(String path) {
        words = new Words(path);
        try {
            words.load();
        } catch (Exception e) {
            view.print("failed to load words file");
            return false;
        }
        return true;
    }

    private boolean loadPlayers(String path) {
        players = new Players(path);
        try {
            players.load();
        } catch (Exception e) {
            view.print("failed to load players file");
            return false;
        }
        return true;
    }

    private void startGame() {
        var layout = new GameLayout(view);
        layout.show();
        Game game;
        try {
            game = new Game(words.pick());

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        var lastTime = System.currentTimeMillis();
        view.print(game.display());
        while ((!game.isSolved()) && (!isExpired(lastTime)) && (game.getFailedTries() < 9)) {
            var c = view.readCharacter("Type a character (" + (180 - getElapsed(lastTime)) + " secs left): ");
            if (c == '*') {
                if (confirm()) {
                    return;
                }
                continue;
            }
            if (game.verify(c)) {
                view.print(game.display());
            } else {
                view.print(HangmanImage.draw(game.getFailedTries()));
            }
        }
        // Show message
        view.print(game.isSolved() ?
                String.format("# You nailed it after %d tires\n", game.getTotalTires()) :
                "# You lost\n");

        // add score
        if (currentPlayer != null) {
            if (game.isSolved()) {
                currentPlayer.addWin();
            } else {
                currentPlayer.addLose();
            }
            try {
                players.save();
            } catch (Exception e) {
                view.print("failed to save score to players file");
            }
        }
    }

    private boolean isExpired(long lastTime) {
        return getElapsed(lastTime) > 180;
    }

    private long getElapsed(long lastTime) {
        return (System.currentTimeMillis() - lastTime) / 1000;
    }

    private void loginPlayer() {
        var loginPlayerLayout = new LoginPlayerLayout(view);
        loginPlayerLayout.show();
        var name = loginPlayerLayout.getName();

        currentPlayer = players.findByName(name);
        if (currentPlayer == null) {
            view.print("sorry, invalid name");
        }
    }

    private void startWords() {
        var layout = new WordsLayout(view);
        while (true) {
            view.print("# What would you like to do with words ");
            var menuItem = layout.getMenuItem();
            switch (menuItem.getOption()) {
                case WORDS_REMOVE: {
                    var removeLayout = new WordsRemoveLayout(view);
                    removeLayout.show();
                    var id = removeLayout.getId();
                    try {
                        words.remove(id);
                        words.save();
                    } catch (Exception e) {
                        view.print("failed to remove word from store");
                    }
                    break;
                }
                case WORDS_ADD: {
                    var addLayout = new WordsAddLayout(view);
                    addLayout.show();
                    try {
                        words.add(addLayout.getName());
                        words.save();
                    } catch (Exception e) {
                        view.print("failed to add word to store");
                    }
                    view.print("");
                    break;
                }
                case WORDS_LIST: {
                    var items = words.get();
                    for (var item : items
                    ) {
                        view.print(item.toString());
                    }
                    view.print("");
                    break;
                }
                case BACK: {
                    return;
                }
            }
        }
    }

    private void startPlayers() {
        var layout = new PlayersLayout(view);
        while (true) {
            var menuItem = layout.getMenuItem();
            switch (menuItem.getOption()) {
                case PLAYERS_REMOVE: {
                    var removeLayout = new PlayersRemoveLayout(view);
                    removeLayout.show();
                    var id = removeLayout.getId();
                    try {
                        players.remove(id);
                        players.save();
                        if (currentPlayer.getId() == id) {
                            currentPlayer = null;
                        }
                    } catch (Exception e) {
                        view.print("failed to remove player from store");
                    }
                    break;
                }
                case PLAYERS_REGISTER: {
                    var addLayout = new PlayersAddLayout(view);
                    addLayout.show();
                    try {
                        players.register(addLayout.getName());
                        players.save();
                    } catch (Exception e) {
                        view.print("failed to add player to store");
                    }
                    view.print("");
                    break;
                }
                case PLAYERS_LIST: {
                    var items = players.get();
                    for (var item : items
                    ) {
                        view.print(item.toString());
                    }
                    view.print("");
                    break;
                }
                case BACK: {
                    return;
                }
            }
        }
    }

    private boolean confirm() {
        view.print("# Are you sure? ");
        var layout = new ConfirmationLayout(view);
        while (true) {
            var menuItem = layout.getMenuItem();
            switch (menuItem.getOption()) {
                case YES: {
                    return true;
                }
                case NO: {
                    return false;
                }
            }
        }
    }
}
