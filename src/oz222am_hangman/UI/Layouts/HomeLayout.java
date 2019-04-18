package oz222am_hangman.UI.Layouts;

import oz222am_hangman.UI.Menu.Menu;
import oz222am_hangman.UI.Menu.Option;
import oz222am_hangman.UI.View;

/**
 * The type Home layout.
 */
public class HomeLayout extends Layout {


    /**
     * Instantiates a new Home layout.
     *
     * @param view the view
     */
    public HomeLayout(View view) {
        super(view);
        setMenu(new Menu(Option.GAME_START, Option.PLAYERS_LOGIN, Option.PLAYERS, Option.WORDS, Option.GAME_QUIT));
    }

    @Override
    public void show() {

    }

}
