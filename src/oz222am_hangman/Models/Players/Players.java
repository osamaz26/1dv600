package oz222am_hangman.Models.Players;


import oz222am_hangman.Models.BaseModelItems;

public class Players extends BaseModelItems<Player> {

    Players() {
        super();
    }

    @Override
    public void read(String path) throws Exception {
        var store = new PlayersStore(path);
        add(store.read());
    }

    public Player register(String name) throws Exception {
        var player = new Player();
        player.setName(name);
        return super.add(player);
    }



}
