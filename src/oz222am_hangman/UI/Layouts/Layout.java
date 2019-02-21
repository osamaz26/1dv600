package oz222am_hangman.UI.Layouts;

import oz222am_hangman.UI.Menu.Menu;
import oz222am_hangman.UI.Menu.MenuItem;
import oz222am_hangman.UI.View;

public abstract class Layout {
    private View view;
    private Menu menu;

    public Layout(View view) {
        this.view = view;
    }

    public abstract void show();

    public MenuItem getMenuItem() {
        return view.showMenu(menu);
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public View getView() {
        return view;
    }
}
