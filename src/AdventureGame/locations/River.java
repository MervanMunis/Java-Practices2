package AdventureGame.locations;

import AdventureGame.obstacle.Bear;
import AdventureGame.player.Player;

public class River extends BattleLocation {
    public River(Player player) {
        super(player, "River", new Bear(), "water", 2);
    }
}
