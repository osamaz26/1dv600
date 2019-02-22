package oz222am_hangman.UI.Layouts.Game;

import oz222am_hangman.UI.Layouts.Layout;
import oz222am_hangman.UI.View;

/**
 * The type Game layout.
 */
public class GameLayout extends Layout {
    /**
     * Instantiates a new Game layout.
     *
     * @param view the view
     */
    public GameLayout(View view) {
        super(view);
    }

    @Override
    public void show() {
        getView().print("# Game started (Press * if you would like to interrupt the game)");
    }


}
