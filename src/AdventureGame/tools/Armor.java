package AdventureGame.tools;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Armor {
    private int id;
    private String name;
    private int defense;
    private int price;

    public static Armor[] armors() {
        Armor[] armorList = new Armor[3];

        armorList[0] = new Armor(1, "light", 1, 15);
        armorList[1] = new Armor(2, "mid", 4, 30);
        armorList[2] = new Armor(3, "heavy", 7, 40);

        return armorList;
    }

    public static Armor getArmorObjectById(int id) {
        for (Armor armor : Armor.armors()) {
            if (armor.getId() == id) {
                return armor;
            }
        }
        return null;
    }
}
