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
    public int readInt(String string){
        System.out.print(string);
        return scanner.nextInt();
    }

    @Override
    public String readLine(String string) {
        // clear previous data
        scanner.nextLine();
        System.out.print(string);
        return scanner.nextLine();
    }

    @Override
    public char readCharacter(String string) {
        System.out.print(string);
        return scanner.next().charAt(0);
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public MenuItem showMenu(Menu menu) {
        print(menu.render());
        MenuItem item = null;
        try {
            item = menu.get(readInt("Choose an option: "));
        } catch (Exception ignored) {
            // Empty buffer
            scanner.nextLine();
        }
        if (item == null) {
            print("# Invalid option selected! ");
            return showMenu(menu);
        }
        return item;
    }


}
