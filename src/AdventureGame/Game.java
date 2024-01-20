package AdventureGame;

import AdventureGame.locations.*;
import AdventureGame.player.Player;

import java.util.Scanner;

public class Game {

    private final Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome To Adventure Game");
        System.out.print("Please enter a name: ");
//        String playerName = input.nextLine();

        Player player = new Player("Mervan");
        System.out.println(player.getName() + " Welcome to this dark and fog island!");

        System.out.println("Now, please choose your character: ");
        player.selectChar();

        Location location = null;

        while (true) {
            player.printPlayerInfo();

            System.out.println();
            System.out.println("*********** Locations ***********");
            System.out.println();
            System.out.println("1 - Safe House");
            System.out.println("2 - Tool Store");
            System.out.println("3 - Cave    -> Award: Food");
            System.out.println("4 - Forest  -> Award: Firewood");
            System.out.println("5 - River   -> Award: Water");
            System.out.println("0 - Exit");

            System.out.print("Please choose the location you want to go: ");
            int selectLocation = input.nextInt();

            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Please enter a valid number.");
            }

            if (location == null) {
                System.out.println("Game Over, Come again.");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game Over");
                break;
            }

        }

    }
}
