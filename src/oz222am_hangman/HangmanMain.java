package oz222am_hangman;


import oz222am_hangman.Models.Games.Game;
import oz222am_hangman.Models.Words.Words;
import oz222am_hangman.UI.Console;
import oz222am_hangman.UI.Menu.Menu;
import oz222am_hangman.UI.Menu.Option;

public class HangmanMain {

    public static void main(String[] args) {
        var words = new Words("words.txt");
        try {
            words.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        var view = new Console();
        view.show();
        var menu = buildMainMenu();
        while (true) {
            var MenuItem = view.showMenu(menu);

            if (MenuItem.getOption().equals(Option.GAME_QUIT)) {
                break;
            } else if (MenuItem.getOption().equals(Option.GAME_PLAY)) {
                Game game = new Game(view, words.pick());
                game.start();
            }
        }
        view.close();
    }

    private static Menu buildMainMenu() {
        var menu = new Menu();
        menu.add(Option.GAME_PLAY);
        menu.add(Option.GAME_START);

        menu.add(Option.PLAYERS_REGISTER);
        menu.add(Option.PLAYERS_REMOVE);
        menu.add(Option.PLAYERS_LOGIN);

        menu.add(Option.WORDS_REMOVE);
        menu.add(Option.GAME_QUIT);
        return menu;
    }



}
