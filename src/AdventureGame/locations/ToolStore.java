package AdventureGame.locations;

import AdventureGame.tools.Armor;
import AdventureGame.tools.Weapon;
import AdventureGame.player.Player;

public class ToolStore extends NormalLocation {

    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("----------- Welcome to Tool Store! -----------");

        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit");

            System.out.print("Select: ");
            int selectCase = input.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Invalid value, try again: ");
                selectCase = input.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See You Later !");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("---------- Weapons ----------");
        System.out.println();

        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + " - \t" + weapon.getName() + "\t <Money: " +
                    weapon.getPrice() + "\t, Damage: " +
                    weapon.getDamage() + ">");
        }
        System.out.println("0 - Exit");
    }

    public void buyWeapon() {
        System.out.print("Select a weapon: ");
        int selectWeaponId = input.nextInt();

        while (selectWeaponId < 1 || selectWeaponId > Weapon.weapons().length) {
            System.out.print("Invalid value, try again: ");
            selectWeaponId = input.nextInt();
        }

        if (selectWeaponId != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjectById(selectWeaponId);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Your balance is not enough!");
                }else {

                    // Buying the weapon
                    System.out.println("You bought the weapon " + selectedWeapon.getName());
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();

                    this.getPlayer().setMoney(balance);
                    System.out.println("your remaining balance: " + this.getPlayer().getMoney());

                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }


    }

    public void buyArmor() {
        System.out.print("Select an armor: ");
        int selectArmorId = input.nextInt();

        while (selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.print("Invalid value, try again: ");
            selectArmorId = input.nextInt();
        }

        if (selectArmorId != 0) {
            Armor selectedArmor = Armor.getArmorObjectById(selectArmorId);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Your balance is not enough!");
                }else {

                    // Buying the weapon
                    System.out.println("You bought the armor " + selectedArmor.getName());
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();

                    this.getPlayer().setMoney(balance);
                    System.out.println("your remaining balance: " + this.getPlayer().getMoney());

                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }

    }

    public void printArmor() {
        System.out.println("---------- Armors ----------");
        System.out.println();

        for (Armor armor : Armor.armors()) {
            System.out.println(
                    armor.getId() + " - " + armor.getName() +
                            " <Price: " + armor.getPrice() +
                            ", Armor: "  + armor.getDefense() + ">");
        }
        System.out.println("0 - Exit");
    }
}
