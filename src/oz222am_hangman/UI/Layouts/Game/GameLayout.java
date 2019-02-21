package oz222am_hangman.UI.Layouts.Game;

import oz222am_hangman.UI.Layouts.Layout;
import oz222am_hangman.UI.View;

public class GameLayout extends Layout {
    public GameLayout(View view) {
        super(view);
    }

    @Override
    public void show() {
        getView().print("# Game started");
    }


}
