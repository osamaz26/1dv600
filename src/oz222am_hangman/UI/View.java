package oz222am_hangman.UI;

import oz222am_hangman.UI.Menu.Menu;
import oz222am_hangman.UI.Menu.MenuItem;

public interface View {
    void show();

    void close();

    int readInt(String string);

    String readLine(String string);

    char readCharacter(String string);

    void print(String string);

    MenuItem showMenu(Menu menu);
}
