package oz222am_hangman;


import oz222am_hangman.UI.Console;

/**
 * The type Hangman main.
 */
public class HangmanMain {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Please set location of words text file in arguments");
            return;
        }
        var view = new Console();
        view.show();
        var hangman = new Hangman(view);
        hangman.start(args[0]);
        view.close();
    }

}
