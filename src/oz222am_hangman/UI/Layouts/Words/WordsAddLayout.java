package oz222am_hangman.UI.Layouts.Words;

import oz222am_hangman.UI.Layouts.Layout;
import oz222am_hangman.UI.View;

/**
 * The type Words add layout.
 */
public class WordsAddLayout extends Layout {
    /**
     * The Name.
     */
    String name;

    /**
     * Instantiates a new Words add layout.
     *
     * @param view the view
     */
    public WordsAddLayout(View view) {
        super(view);
    }

    public void show() {
        name = getView().readLine("Please write the name of the word: ");

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
