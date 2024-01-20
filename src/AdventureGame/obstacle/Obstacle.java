package AdventureGame.obstacle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Obstacle {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int award;
    private int originalHealth;

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }
}
