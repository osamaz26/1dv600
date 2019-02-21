package oz222am_hangman.UI.Layouts.Words;

import oz222am_hangman.UI.Layouts.Layout;
import oz222am_hangman.UI.Menu.Menu;
import oz222am_hangman.UI.Menu.Option;
import oz222am_hangman.UI.View;

public class WordsLayout extends Layout {
    public WordsLayout(View view) {
        super(view);
        setMenu(new Menu(Option.WORDS_REMOVE, Option.WORDS_ADD, Option.WORDS_LIST, Option.BACK));
    }

    @Override
    public void show() {

    }
}
