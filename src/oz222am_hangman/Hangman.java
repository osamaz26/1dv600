package oz222am_hangman;


import oz222am_hangman.Models.Games.Game;
import oz222am_hangman.Models.Words.Words;
import oz222am_hangman.UI.HangmanImage;
import oz222am_hangman.UI.Layouts.Game.GameLayout;
import oz222am_hangman.UI.Layouts.HomeLayout;
import oz222am_hangman.UI.Layouts.Players.PlayersLayout;
import oz222am_hangman.UI.Layouts.Words.WordsAddLayout;
import oz222am_hangman.UI.Layouts.Words.WordsLayout;
import oz222am_hangman.UI.View;

public class Hangman {
    private View view;
    private Words words;

    public Hangman(View view) {
        this.view = view;
    }

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
            var menuItem = layout.getMenuItem();
            switch (menuItem.getOption()) {
                case GAME_QUIT: {

                    return;
                }
                case GAME_PLAY: {
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
            if (game.verify(c)) {
                view.print(game.display());
            } else {
                view.print(HangmanImage.draw(game.getFailedTries()));
            }
        }
        if (game.isSolved()) {
            view.print(String.format("# You nailed it after %d tires", game.getTotalTires()));
        }
    }

    private void startWords() {
        var layout = new WordsLayout(view);
        while (true) {
            var menuItem = layout.getMenuItem();
            switch (menuItem.getOption()) {
                case WORDS_REMOVE: {
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
                    var list = words.get();
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
                    break;
                }
                case PLAYERS_REMOVE: {
                    break;
                }
                case PLAYERS_LIST: {

                    break;
                }
                case BACK: {
                    return;
                }
            }
        }
    }
}
