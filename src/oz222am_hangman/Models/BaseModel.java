package oz222am_hangman.Models;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseModel {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
