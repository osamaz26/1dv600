package oz222am_hangman.UI.Layouts.Players;

import oz222am_hangman.UI.Layouts.Layout;
import oz222am_hangman.UI.Menu.Menu;
import oz222am_hangman.UI.Menu.Option;
import oz222am_hangman.UI.View;

/**
 * The type Players layout.
 */
public class PlayersLayout extends Layout {
    /**
     * Instantiates a new Players layout.
     *
     * @param view the view
     */
    public PlayersLayout(View view) {
        super(view);
        setMenu(new Menu(Option.PLAYERS_REGISTER, Option.PLAYERS_REMOVE, Option.PLAYERS_LIST, Option.BACK));
    }

    @Override
    public void show() {

    }
}
