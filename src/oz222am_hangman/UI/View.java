package oz222am_hangman.UI;

import oz222am_hangman.UI.Menu.Menu;
import oz222am_hangman.UI.Menu.MenuItem;

public interface View {
    void show();

    void close();

    int readInt();

    int readInt(String string);

    String readLine();

    boolean hasNext();

    void print(String string);

    MenuItem showMenu(Menu menu);
}
