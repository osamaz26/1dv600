package oz222am_hangman;


import oz222am_hangman.Models.Games.Game;
import oz222am_hangman.Models.Words.Words;
import oz222am_hangman.UI.HangmanImage;
import oz222am_hangman.UI.Layouts.ConfirmationLayout;
import oz222am_hangman.UI.Layouts.Game.GameLayout;
import oz222am_hangman.UI.Layouts.HomeLayout;
import oz222am_hangman.UI.Layouts.Players.PlayersLayout;
import oz222am_hangman.UI.Layouts.Words.WordsAddLayout;
import oz222am_hangman.UI.Layouts.Words.WordsLayout;
import oz222am_hangman.UI.View;

/**
 * The type Hangman.
 */
public class Hangman {
    private View view;
    private Words words;

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
     * @param wordsPath the words path
     */
    void start(String wordsPath) {
        words = new Words(wordsPath);
        try {
            words.load();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        var layout = new HomeLayout(view);
        while (true) {
            view.print("# What would you like to do ");
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
            }
        }
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
        view.print(game.display());
        while ((!game.isSolved()) && (game.getFailedTries() < 9)) {
            var c = view.readCharacter("Type a character: ");
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
        if (game.isSolved()) {
            view.print(String.format("# You nailed it after %d tires\n", game.getTotalTires()));
        } else {
            view.print("# You lost\n");
        }
    }

    private void startWords() {
        var layout = new WordsLayout(view);
        while (true) {
            var menuItem = layout.getMenuItem();
            switch (menuItem.getOption()) {
                case WORDS_REMOVE: {
                    // Todo: implementation

                    break;
                }
                case WORDS_ADD: {
                    var addLayout = new WordsAddLayout(view);
                    addLayout.show();
                    try {
                        words.add(addLayout.getName());
                        words.save();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case WORDS_LIST: {
                    // Todo: implementation
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
                case PLAYERS_REGISTER: {
                    // Todo: implementation
                    break;
                }
                case PLAYERS_REMOVE: {
                    // Todo: implementation
                    break;
                }
                case PLAYERS_LIST: {
                    // Todo: implementation
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
