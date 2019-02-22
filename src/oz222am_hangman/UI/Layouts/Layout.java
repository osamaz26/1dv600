package oz222am_hangman.UI.Layouts;

import oz222am_hangman.UI.Menu.Menu;
import oz222am_hangman.UI.Menu.MenuItem;
import oz222am_hangman.UI.View;

/**
 * The type Layout.
 */
public abstract class Layout {
    private View view;
    private Menu menu;

    /**
     * Instantiates a new Layout.
     *
     * @param view the view
     */
    public Layout(View view) {
        this.view = view;
    }

    /**
     * Show.
     */
    public abstract void show();

    /**
     * Gets menu item.
     *
     * @return the menu item
     */
    public MenuItem getMenuItem() {
        return view.showMenu(menu);
    }

    /**
     * Sets menu.
     *
     * @param menu the menu
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * Gets view.
     *
     * @return the view
     */
    public View getView() {
        return view;
    }
}
