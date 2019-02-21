package oz222am_hangman.UI.Layouts;

import oz222am_hangman.UI.Menu.Menu;
import oz222am_hangman.UI.Menu.Option;
import oz222am_hangman.UI.View;

public class ConfirmationLayout extends Layout {


    public ConfirmationLayout(View view) {
        super(view);
        setMenu(new Menu(Option.YES, Option.NO));
    }

    @Override
    public void show() {

    }

}
