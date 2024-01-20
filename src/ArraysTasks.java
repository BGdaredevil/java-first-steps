import java.util.Arrays;
import java.util.Scanner;

public class ArraysTasks {
    public static void main(String[] args) {

//        sumFirstAndLast();
//        weekDay();
//        reverseArr();
//        reverseStrArr();
//        sumEvenNums();
//        evenOddSubNums();
//        equalArrs();
//        condenseArr();
        printEachNth();
    }

    private static void printEachNth() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get arr");

        String[] inputArr = sc.nextLine().split(",");

        System.out.println("step");
        int step = sc.nextInt();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputArr.length; i += step) {
            result.append(inputArr[i]).append(" ");
        }

        result.append("\n");
        System.out.println(result.toString());

    }

    private static void condenseArr() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get arr");
        int[] inputOne = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        while (inputOne.length > 1) {
            int[] sums = new int[inputOne.length - 1];

            for (int i = 1; i < inputOne.length; i++) {
                sums[i - 1] = inputOne[i - 1] + inputOne[i];
            }

            inputOne = sums;
        }

        System.out.println(inputOne[0]);
    }

    private static void equalArrs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get arr");
        int[] inputOne = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("get arr");
        int[] inputTwo = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;

        for (int i = 0; i < inputOne.length; i++) {
            if (i == inputTwo.length) {
                System.out.printf("Arrays are not identical. Found difference at %d index.\n", i);
                return;
            }

            if (inputTwo[i] != inputOne[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.\n", i);
                return;
            }

            if (i == inputOne.length - 1 && i < inputTwo.length - 1) {
                System.out.printf("Arrays are not identical. Found difference at %d index.\n", (i + 1));
                return;
            }

            sum += inputOne[i];
        }

        System.out.printf("Arrays are identical. Sum: %d", sum);
    }

    private static void evenOddSubNums() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get arr");
        int evenSum = 0;
        int oddSum = 0;
        int[] input = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 == 0) {
                evenSum += input[i];
            } else {
                oddSum += input[i];
            }
        }

        System.out.println(evenSum - oddSum);
    }

    private static void sumEvenNums() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get arr");

        int[] input = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int result = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 == 0) {
                result += input[i];
            }
        }

        System.out.println(result);

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
