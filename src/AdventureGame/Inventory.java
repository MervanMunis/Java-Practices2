package AdventureGame;

import AdventureGame.tools.Armor;
import AdventureGame.tools.Weapon;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inventory {
    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.weapon = new Weapon(-1, "Punch",0,0);
        this.armor = new Armor(-1, "rag", 0, 0);
    }


}
