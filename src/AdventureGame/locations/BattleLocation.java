package AdventureGame.locations;

import AdventureGame.Location;
import AdventureGame.obstacle.Obstacle;
import AdventureGame.player.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class BattleLocation extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacles;
    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacles) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacles = maxObstacles;

    }

    public int randomObstacleNumber() {
        Random random = new Random();
        return random.nextInt(this.getMaxObstacles()) + 1;
    }

    @Override
    public boolean onLocation() {
        int obstacleNumber = this.randomObstacleNumber();

        System.out.println("Now, you are here: " + this.getName());
        System.out.println("Careful! There are/is " + obstacleNumber + " " +
                this.getObstacle().getName() + "/s"+ "Around Here!");

        System.out.print("<A> Attack  or <R> Run!");
        String selectBattleCase = input.nextLine().toUpperCase();

        if (selectBattleCase.equals("A")) {
            if (combat(obstacleNumber)) {
                System.out.println(this.getName() + " You defeated all of you enemies !");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You died !");
            return false;
        }

        return true;
    }

    public boolean combat(int obstacleNumber) {
        for (int i=1; i<=obstacleNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStatistics();
            obstacleStatistics(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() >0) {
                System.out.print("<A> Attack or <R> Run: ");
                String selectCombat = input.nextLine().toUpperCase();

                if (selectCombat.equals("A")) {
                    System.out.println("You hit the obstacle");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0 ) {
                        System.out.println();
                        System.out.println("You hit the monster.");

                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefense();

                        if (obstacleDamage < 0 ) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You defeated the enemies!");
                System.out.println(this.getObstacle().getAward() + " money gained!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Current money: " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Health of Player: " + this.getPlayer().getHealth());
        System.out.println("Health of " + this.getObstacle().getName()+ " is " + this.getObstacle().getHealth());
        System.out.println("---------------------------");;
    }
    public void playerStatistics() {
        System.out.println("Player:");
        System.out.println("-----------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Defence: " + this.getPlayer().getInventory().getArmor().getDefense());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStatistics(int i) {
        System.out.println(i + ". " + this.getObstacle().getName());
        System.out.println("-------------------------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
        System.out.println();
    }
}
