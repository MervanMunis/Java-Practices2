package AdventureGame.player;

import AdventureGame.gamecharacters.Archer;
import AdventureGame.gamecharacters.GameCharacters;
import AdventureGame.Inventory;
import AdventureGame.gamecharacters.Knight;
import AdventureGame.gamecharacters.Samurai;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {

    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String charName;
    private String name;
    private final Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void selectChar() {
        GameCharacters[] characters = {new Samurai(), new Archer(), new Knight()};

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Characters: ");

        for (GameCharacters character : characters) {
            System.out.println(
                    "Id: " + character.getId() +
                    "\t Character: " + character.getName() +
                    "\t Damage: " + character.getDamage() +
                    "\t Health: " + character.getHealth() +
                    "\t Money: " + character.getMoney()
            );
        }
        System.out.println("-----------------------------------------------------------------------------");

        System.out.print("Now, please enter the character Id you want to play: ");
        int selectCharacter = input.nextInt();

        switch (selectCharacter) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

        System.out.println("Character: " + this.getCharName() + ", Damage: " + this.getDamage() +
                ", Health: " + this.getHealth() +
                ", Money: " + this.getMoney()
                );
    }

    public void initPlayer(GameCharacters gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printPlayerInfo() {
        System.out.println("Your Weapon: " + this.getInventory().getWeapon().getName() +
                ", Armor: " + this.getInventory().getArmor().getName() +
                ", Defence: " + this.getInventory().getArmor().getDefense() +
                ", Damage: " + this.getTotalDamage() +
                ", Health: " + this.getHealth() +
                ", Money: " + this.getMoney()
        );
    }

}
