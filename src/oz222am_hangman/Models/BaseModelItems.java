package oz222am_hangman.Models;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseModelItems<T extends BaseModel> {
    private int index;
    private Map<Integer, T> list;

    public BaseModelItems() {
        list = new HashMap<>();
    }

    public void remove(int id) throws Exception {
        if (!list.containsKey(id)) {
            throw new Exception("Item not found");
        }
        list.remove(id);
    }

    public T add(T item) {
        list.put(index++, item);
        return item;
    }

    public void add(List<T> items) {
        for (T item: items) {
            list.put(item.getId(), item);
        }
    }

    public Collection<T> getValues() {
        return list.values();
    }

    public int getSize(){
        return list.size();
    }

    public abstract void read(String path) throws Exception;
}
