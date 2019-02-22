package oz222am_hangman.UI.Menu;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Menu.
 */
public class Menu {
    private Map<Integer, MenuItem> items = new HashMap<>();

    /**
     * Instantiates a new Menu.
     */
    public Menu() {

    }

    /**
     * Instantiates a new Menu.
     *
     * @param args the args
     */
    public Menu(Option... args) {
        add(args);
    }

    /**
     * Add.
     *
     * @param args the args
     */
    public void add(Option... args) {
        for (var option : args) {
            add(items.size() + 1, option);
        }
    }

    /**
     * Add.
     *
     * @param option the option
     */
    public void add(Option option) {
        add(items.size() + 1, option);
    }

    /**
     * Add.
     *
     * @param id     the id
     * @param option the option
     */
    public void add(int id, Option option) {
        items.put(id, new MenuItem(id, option));
    }

    /**
     * Render string.
     *
     * @return the string
     */
    public String render() {
        StringBuilder result = new StringBuilder();
        for (var item : items.values()) {
            result.append(item.toString()).append("\n");
        }
        return result.toString();
    }

    /**
     * Has item boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean hasItem(int id) {
        return items.containsKey(id);
    }

    /**
     * Get menu item.
     *
     * @param id the id
     * @return the menu item
     */
    public MenuItem get(int id) {
        return items.get(id);
    }
}
