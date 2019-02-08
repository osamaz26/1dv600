package oz222am_hangman.Models;

import java.util.List;

public abstract class Store<T> {
    private String path;

    public Store(String path) {
        setPath(path);
    }


    public abstract List<T> read() throws Exception;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
