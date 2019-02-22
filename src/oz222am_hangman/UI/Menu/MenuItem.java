package oz222am_hangman.UI.Menu;


/**
 * The type Menu item.
 */
public class MenuItem {
    private int id;
    private Option option;

    /**
     * Instantiates a new Menu item.
     *
     * @param id     the id
     * @param option the option
     */
    MenuItem(int id, Option option) {
        this.id = id;
        this.option = option;
    }

    /**
     * Gets option.
     *
     * @return the option
     */
    public Option getOption() {
        return option;
    }

    /**
     * Sets option.
     *
     * @param option the option
     */
    public void setOption(Option option) {
        this.option = option;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return String.format("[%d]: %s", id, Option.toString(option));
    }
}
