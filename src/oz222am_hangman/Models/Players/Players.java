package oz222am_hangman.Models.Players;


import oz222am_hangman.Models.Items;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * The type Players.
 */
public class Players extends Items<Player> {

    /**
     * Instantiates a new Players.
     */
    public Players() {
        super();
    }

    public Players(String path) {
        super();
        setPath(path);
    }

    @Override
    public void load() throws Exception {
        var bufferedReader = new BufferedReader(new FileReader(getPath()));
        int id, numberOfWins, numberOfLoses;
        String name;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            var pos = line.indexOf(" ");
            if (pos < 0) {
                continue;
            }
            id = Integer.parseInt(line.substring(0, pos));
            var winPos = line.indexOf(" ", pos + 1);
            if (winPos < 0) {
                continue;
            }
            numberOfWins = Integer.parseInt(line.substring(pos + 1, winPos));
            var losePos = line.indexOf(" ", winPos + 1);
            if (losePos < 0) {
                continue;
            }
            numberOfLoses = Integer.parseInt(line.substring(winPos + 1, losePos));
            name = line.substring(losePos + 1);
            var player = new Player();
            player.setId(id);
            player.setName(name);
            player.setNumberOfWins(numberOfWins);
            player.setNumberOfLoses(numberOfLoses);
            add(player);
        }
        bufferedReader.close();
    }

    @Override
    public void save() throws Exception {
        var bufferedWriter = new BufferedWriter(new FileWriter(getPath()));
        for (var player : getValues()) {
            bufferedWriter.write(
                    player.getId() + " " +
                            player.getNumberOfWins() + " " +
                            player.getNumberOfLoses() + " " +
                            player.getName() + "\n");
        }
        bufferedWriter.close();
    }

    public Player add(String value) throws Exception {
        var player = new Player();
        player.setName(value);
        return super.add(player);
    }

    /**
     * Register player.
     *
     * @param name the name
     * @return the player
     * @throws Exception the exception
     */
    public Player register(String name) throws Exception {
        var player = new Player();
        player.setName(name);
        save();
        return super.add(player);
    }

    public Player findByName(String name) {
        for (var player: getValues()
             ) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

}
