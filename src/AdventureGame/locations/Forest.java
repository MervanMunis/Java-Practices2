package AdventureGame.locations;

import AdventureGame.obstacle.Vampire;
import AdventureGame.player.Player;

public class Forest extends BattleLocation {
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "Firewood", 3);
    }
}
