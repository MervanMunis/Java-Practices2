package AdventureGame.gamecharacters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class GameCharacters {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int money;


}
