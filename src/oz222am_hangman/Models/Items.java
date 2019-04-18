package oz222am_hangman.Models;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Items.
 *
 * @param <T> the type parameter
 */
public abstract class Items<T extends Model> {
    private int index;
    private Map<Integer, T> list;
    private String path;

    /**
     * Instantiates a new Items.
     */
    public Items() {
        list = new HashMap<>();
    }

    /**
     * Remove.
     *
     * @param id the id
     * @throws Exception the exception
     */
    public void remove(int id) throws Exception {
        if (!list.containsKey(id)) {
            throw new Exception("Option not found");
        }
        list.remove(id);
    }

    /**
     * Add t.
     *
     * @param item the item
     * @return the t
     */
    public T add(T item) {
        if (item.getId() == Integer.MIN_VALUE) {
            item.setId(index++);
        } else if (item.getId() >= index) {
            index = item.getId() + 1;
        }
        list.put(item.getId(), item);
        return item;
    }

    /**
     * Add.
     *
     * @param items the items
     */
    public void add(List<T> items) {
        for (T item : items) {
            list.put(item.getId(), item);
        }
    }


    /**
     * Gets values.
     *
     * @return the values
     */
    public Collection<T> getValues() {
        return list.values();
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Load.
     *
     * @throws Exception the exception
     */
    public abstract void load() throws Exception;

    /**
     * Save.
     *
     * @throws Exception the exception
     */
    public abstract void save() throws Exception;

    /**
     * Gets path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets path.
     *
     * @param path the path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Collection<T> get() {
        return list.values();
    }
}
