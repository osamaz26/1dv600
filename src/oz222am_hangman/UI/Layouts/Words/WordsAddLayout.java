package oz222am_hangman.UI.Layouts.Words;

import oz222am_hangman.UI.Layouts.Layout;
import oz222am_hangman.UI.View;

public class WordsAddLayout extends Layout {
    String name;

    public WordsAddLayout(View view) {
        super(view);
    }

    public void show() {
        name = getView().readLine("Please write the name of the word: ");

    }

    public String getName() {
        return name;
    }
}
