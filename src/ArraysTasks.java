import java.util.Arrays;
import java.util.Scanner;

public class ArraysTasks {
    public static void main(String[] args) {

//        sumFirstAndLast();
//        weekDay();
    }

    private static void weekDay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get dayindex");
        int dayIndex = sc.nextInt();
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (dayIndex < 0 || dayIndex >= days.length) {
            System.out.println("Invalid Day!");
            return;
        }

        System.out.println(days[dayIndex]);

    }

    private static void sumFirstAndLast() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get arr");

        int[] theData = Arrays.stream(sc.nextLine().split(",")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int result = theData[0] + theData[theData.length - 1];

        System.out.println(result);
    }
}
