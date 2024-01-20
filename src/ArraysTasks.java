import java.util.Arrays;
import java.util.Scanner;

public class ArraysTasks {
    public static void main(String[] args) {

//        sumFirstAndLast();
//        weekDay();
//        reverseArr();
        reverseStrArr();

    }

    private static void reverseStrArr() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get num");
        String[] input = sc.nextLine().split(",");

        for (int i = 0; i < input.length / 2; i++) {
            String temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;

        }

        for (var i : input) {
            System.out.printf("%s ", i);
        }

    }

    private static void reverseArr() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get num");
        int count = Integer.parseInt(sc.nextLine());
        System.out.println("get arr");
        String arrInputStr = sc.nextLine();

        int[] input = Arrays.stream(arrInputStr.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[count];

        for (int i = 0; i < count; i++) {
            if (input.length > i && result.length > i) {
                result[i] = input[i];
            }
        }

        for (int i = 0; i < count / 2; i++) {
            result[i] ^= result[result.length - 1 - i];
            result[result.length - 1 - i] ^= result[i];
            result[i] ^= result[result.length - 1 - i];
        }

        for (int i : result) {
            System.out.printf("%d ", i);
        }

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
