package oz222am_hangman.UI;

import oz222am_hangman.UI.Menu.Menu;
import oz222am_hangman.UI.Menu.MenuItem;

/**
 * The interface View.
 */
public interface View {
    /**
     * Show.
     */
    void show();

    /**
     * Close.
     */
    void close();

    /**
     * Read int int.
     *
     * @param string the string
     * @return the int
     */
    int readInt(String string);

    /**
     * Read line string.
     *
     * @param string the string
     * @return the string
     */
    String readLine(String string);

    /**
     * Read character char.
     *
     * @param string the string
     * @return the char
     */
    char readCharacter(String string);

    /**
     * Print.
     *
     * @param string the string
     */
    void print(String string);

    /**
     * Show menu menu item.
     *
     * @param menu the menu
     * @return the menu item
     */
    MenuItem showMenu(Menu menu);
}
