package AdventureGame.tools;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int price;

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];

        weaponList[0] = new Weapon(1,"Gun",2, 5);
        weaponList[1] = new Weapon(2,"Sword",6, 35);
        weaponList[2] = new Weapon(3,"Spear",8, 45);

        return weaponList;
    }

    public static Weapon getWeaponObjectById(int id) {
        for (Weapon weapon : Weapon.weapons()) {
            if (weapon.getId() == id) {
                return weapon;
            }
        }
        return null;
    }
}
