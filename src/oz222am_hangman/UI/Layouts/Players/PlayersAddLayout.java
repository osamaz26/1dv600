package oz222am_hangman.UI.Layouts.Players;

import oz222am_hangman.UI.Layouts.Layout;
import oz222am_hangman.UI.View;

/**
 * The type Words add layout.
 */
public class PlayersAddLayout extends Layout {
    /**
     * The Name.
     */
    String name;

    /**
     * Instantiates a new Players add layout.
     *
     * @param view the view
     */
    public PlayersAddLayout(View view) {
        super(view);
    }

    public void show() {
        name = getView().readLine("Please write the name of the player: ");

    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
