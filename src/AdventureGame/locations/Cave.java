package AdventureGame.locations;

import AdventureGame.obstacle.Zombie;
import AdventureGame.player.Player;

public class Cave extends BattleLocation {

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food", 3);
    }
}
