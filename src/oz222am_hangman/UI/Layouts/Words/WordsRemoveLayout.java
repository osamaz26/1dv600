package oz222am_hangman.UI.Layouts.Words;

import oz222am_hangman.UI.Layouts.Layout;
import oz222am_hangman.UI.View;

/**
 * The type Words add layout.
 */
public class WordsRemoveLayout extends Layout {

    int id;

    /**
     * Instantiates a new Words remove layout.
     *
     * @param view the view
     */
    public WordsRemoveLayout(View view) {
        super(view);
    }

    public void show() {
        id = getView().readInt("Please write the word id: ");

    }

    public int getId() {
        return id;
    }
}
