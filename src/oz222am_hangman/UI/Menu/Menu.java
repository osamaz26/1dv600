package oz222am_hangman.UI.Menu;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, MenuItem> items = new HashMap<>();

    public Menu() {

    }

    public void add(Option option) {
        add(items.size() + 1, option);
    }

    public void add(int id, Option option) {
        items.put(id, new MenuItem(id, option));
    }

    public String render() {
        StringBuilder result = new StringBuilder();
        for (var item : items.values()) {
            result.append(item.toString()).append("\n");
        }
        return result.toString();
    }

    public boolean hasItem(int id) {
        return items.containsKey(id);
    }

    public MenuItem get(int id) {
        return items.get(id);
    }
}
