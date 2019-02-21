package oz222am_hangman.UI.Layouts;

import oz222am_hangman.UI.Menu.Menu;
import oz222am_hangman.UI.Menu.Option;
import oz222am_hangman.UI.View;

public class HomeLayout extends Layout {


    public HomeLayout(View view) {
        super(view);
        setMenu(new Menu(Option.GAME_PLAY, Option.GAME_START, Option.PLAYERS, Option.WORDS, Option.GAME_QUIT));
    }

    @Override
    public void show() {

    }

}
