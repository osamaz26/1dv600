package oz222am_hangman.UI.Layouts.Players;

import oz222am_hangman.UI.Layouts.Layout;
import oz222am_hangman.UI.View;

/**
 * The type Words add layout.
 */
public class PlayersRemoveLayout extends Layout {

    int id;

    /**
     * Instantiates a new Words remove layout.
     *
     * @param view the view
     */
    public PlayersRemoveLayout(View view) {
        super(view);
    }

    public void show() {
        id = getView().readInt("Please write the player id: ");

    }

    public int getId() {
        return id;
    }
}
