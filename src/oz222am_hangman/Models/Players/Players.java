package oz222am_hangman.Models.Players;


import oz222am_hangman.Models.Items;

import java.io.*;

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

    /**
     * Instantiates a new Players.
     *
     * @param path the path
     */
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
                throw new IOException("Ill-formatted file");
            }
            id = Integer.parseInt(line.substring(0, pos));
            var winPos = line.indexOf(" ", pos + 1);
            if (winPos < 0) {
                throw new IOException("Ill-formatted file");
            }
            numberOfWins = Integer.parseInt(line.substring(pos + 1, winPos));
            var losePos = line.indexOf(" ", winPos + 1);
            if (losePos < 0) {
                throw new IOException("Ill-formatted file");
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
        return super.add(player);
    }

    /**
     * Find by name player.
     *
     * @param name the name
     * @return the player
     */
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
