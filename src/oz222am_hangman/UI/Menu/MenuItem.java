package oz222am_hangman.UI.Menu;


public class MenuItem {
    private int id;
    private Option option;

    MenuItem(int id, Option option) {
        this.id = id;
        this.option = option;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return String.format("[%d]: %s", id, Option.toString(option));
    }
}
