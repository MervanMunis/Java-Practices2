import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageCalculator {

    public static float calculateAverage() {
        List<Integer> grades = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.print("Math Grade: ");
        int math = input.nextInt();
        grades.add(math);

        System.out.print("Physics Grade: ");
        int physics = input.nextInt();
        grades.add(physics);

        System.out.print("Chemistry Grade: ");
        int chemistry = input.nextInt();
        grades.add(chemistry);

        System.out.print("Turkish Grade: ");
        int turkish = input.nextInt();
        grades.add(turkish);

        System.out.print("History Grade: ");
        int history = input.nextInt();
        grades.add(history);

        System.out.print("Music Grade: ");
        int music = input.nextInt();
        grades.add(music);

        int total = grades.stream().mapToInt(Integer::intValue).sum();
        float average = (float) (total / grades.size());
        System.out.println("Your average: " + average);
        return average;
    }
}
