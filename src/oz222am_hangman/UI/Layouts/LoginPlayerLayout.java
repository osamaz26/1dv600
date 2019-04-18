package oz222am_hangman.UI.Layouts;

import oz222am_hangman.UI.View;

/**
 * The type Words add layout.
 */
public class LoginPlayerLayout extends Layout {
    /**
     * The Name.
     */
    String name;

    /**
     * Instantiates a new Players add layout.
     *
     * @param view the view
     */
    public LoginPlayerLayout(View view) {
        super(view);
    }

    public void show() {
        name = getView().readLine("Please write your name: ");

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
