// First, we need to generate a pure table (2D Array) with a method.
// Then, we need to generate the random mines and add it into pure table.
// So, we get the table with mines.
// Then, we need a while loop until we win or fail.
// Then, after each click (entered row, and column) we need to store in a need table.
// Then, if there is no mine, we change to "0 ".
// Then, if there is mine, then we change to "*" and game over.

import java.util.*;
public class MineSweeper {

    private final int rowSize;
    private final int columnSize;

    public MineSweeper(int rowSize, int columnSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
    }
    public void run() {
        int chance = 4;

        System.out.println("Welcome To Mine Sweeper Game!");

        Scanner input = new Scanner(System.in);

        String[][] resultTable = table(columnSize, rowSize);
        String[][] generatedRandomMine = generateRandomMine(columnSize, rowSize, chance);

        printResultTable(columnSize, rowSize, resultTable);

        boolean status = true;
        int times = (columnSize*rowSize) - (columnSize*rowSize)/4;

        while (status && times>0) {
            System.out.print("Enter the row number: ");
            int row = input.nextInt();

            System.out.print("Enter the column number: ");
            int column = input.nextInt();

            if (Objects.equals(generatedRandomMine[column][row], "* ")) {
                resultTable[column][row] = "* ";

                printResultTable(columnSize, rowSize, resultTable);

                status = false;
            } else if (Objects.equals(generatedRandomMine[column][row], "- ")) {
                resultTable[column][row] = "0 ";

                printResultTable(columnSize, rowSize, resultTable);
            }

            if (!status) {
                System.out.println("Game is Over!");
            }
            times--;
        }
        if (status) {
            System.out.println("You wow the game.");
        }
    }

    public static String[][] generateRandomMine(int columnSize, int rowSize, int chance) {
        String[][] pureTable = table(columnSize, rowSize);

        int totalNumber = columnSize * rowSize;

        // Define the number of elements to choose (chance% of the total)
        int elementsToChoose = totalNumber / chance;

        // Random object for generating random indices
        Random random = new Random();

        // Choose chance% of the elements randomly and set them to a specific value
        for (int z = 1; z<=elementsToChoose; z++) {
            int randomRow = random.nextInt(rowSize);
            int randomColumn = random.nextInt(columnSize);

            pureTable[randomColumn][randomRow] = "* ";
        }
        return pureTable;
    }

    public static void printResultTable(int columnSize, int rowSize, String[][] resultTable) {
        for (int i = 0; i < columnSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                System.out.print(resultTable[i][j]);
            }
            System.out.println();
        }
    }

    public static String[][] table(int columnSize, int rowSize) {
        String[][] tableOfMine = new String[columnSize][rowSize];

        for (int i = 0; i < columnSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                tableOfMine[i][j] = "- ";
            }
        }
//        System.out.println(Arrays.deepToString(tableOfMine));
        return tableOfMine;
    }
}
