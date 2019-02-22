package oz222am_hangman.Models.Players;

import oz222am_hangman.Models.Model;

/**
 * The type Player.
 */
public class Player extends Model {
    private String name;


    /**
     * Instantiates a new Player.
     */
    public Player() {

    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @throws Exception the exception
     */
    public void setName(String name) throws Exception {
        if (!validateName(name)) {
            throw new Exception("invalid name");
        }
        this.name = name;
    }

    /**
     * Validate name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean validateName(String name) {
        return !name.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("[%d] Player: %s", getId(), name);
    }
}
