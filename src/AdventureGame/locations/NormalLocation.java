package AdventureGame.locations;

import AdventureGame.Location;
import AdventureGame.player.Player;

public abstract class NormalLocation extends Location {

    public NormalLocation(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
