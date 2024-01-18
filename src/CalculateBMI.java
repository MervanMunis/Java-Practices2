import java.util.Scanner;

public class CalculateBMI {

    public static double bodyMassIndex() {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your height: ");
        float height = input.nextFloat();

        System.out.print("Please enter your weight: ");
        float weight = input.nextFloat();

        return (weight/(Math.pow(height, 2)));
    }
}
