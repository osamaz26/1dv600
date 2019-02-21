package oz222am_hangman.UI;

import oz222am_hangman.UI.Menu.Menu;
import oz222am_hangman.UI.Menu.MenuItem;

import java.util.Scanner;

public class Console implements View {
    private Scanner scanner;

    @Override
    public void show() {
        scanner = new Scanner(System.in);
        print("# Welcome to Hangman game");
    }

    @Override
    public void close() {
        print("# Thank you for playing fair!");
        scanner.close();
    }

    @Override
    public int readInt() {
        return scanner.nextInt();
    }

    @Override
    public int readInt(String string) {
        System.out.print(string);
        return scanner.nextInt();
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public MenuItem showMenu(Menu menu) {
        print(menu.render());
        var item = menu.get(readInt("Choose an option: "));
        if (item == null) {
            print("# Invalid option selected! ");
            return showMenu(menu);
        }
        return item;
    }
}
