package oz222am_hangman.Models.Players;

import oz222am_hangman.Models.BaseModel;

public class Player extends BaseModel {
    private String name;


    Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (!validateName(name)) {
            throw new Exception("invalid name");
        }
        this.name = name;
    }

    public boolean validateName(String name) {
        return !name.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("[%d] Player: %s", getId(), name);
    }
}
