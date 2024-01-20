import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
//        printEachNth();
//        addRemove();
//        arrayRotate();
//        extractNonDecreasing();
//        rearrange();
//        firstLastK();
//        lastKseq();
//        processOddNums();
//        smallestTwo();
//        productList();
//        arrayManipulate();
        getSeq();

    }

    private static void getSeq() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get input");

        int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int start = 0;
        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1]) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            if (currentLength >= maxLength) {
                maxLength = currentLength;
                start = i - currentLength + 1;
            }
        }

        System.out.println((input[start] + "").repeat(maxLength));
    }

    private static void arrayManipulate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get input");

        int[] inputArr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> data = new ArrayList<Integer>(inputArr.length);

        for (int item : inputArr) {
            data.add(item);
        }

        System.out.println("get orders");
        String[] operations = sc.nextLine().split("\\s*,\\s*");

        for (String operation : operations) {
            String[] opParams = operation.split(" ");
            switch (opParams[0]) {
                case "Add": {
                    data.add(Integer.parseInt(opParams[1]));
                    break;
                }

                case "Remove": {
                    int index = data.indexOf(Integer.parseInt(opParams[1]));
                    if (index > 0) {
                        data.remove(index);
                    }

                    break;
                }

                case "RemoveAt": {
                    int index = (Integer.parseInt(opParams[1]));
                    if (index >= 0 && index < data.size()) {
                        data.remove(index);
                    }

                    break;
                }

                case "Insert": {
                    int num = (Integer.parseInt(opParams[1]));
                    int index = (Integer.parseInt(opParams[2]));

                    if (index >= 0 && index < data.size()) {
                        data.add(index, num);
                    }

                    break;
                }
            }
        }

        StringBuilder res = new StringBuilder();

        for (int num : data) {
            res.append(num).append(" ");
        }

        System.out.println(res.toString());
    }

    private static void productList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get list");

        String[] input = sc.nextLine().split("\\s*,\\s*");

        for (int i = 1; i <= input.length; i++) {
            System.out.printf("%d.%s\n", i, input[i - 1]);
        }
    }

    private static void smallestTwo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get arr");

        int[] input = Arrays.stream(sc.nextLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int inputItem : input) {
            if (smallest > inputItem) {
                secondSmallest = smallest;
                smallest = inputItem;
            }
        }

        System.out.printf("%d %d\n", smallest, secondSmallest);
    }

    private static void processOddNums() {
        Scanner sc = new Scanner(System.in);

        int[] inputArr = Arrays.stream(sc.nextLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 1; i < inputArr.length; i += 2) {
            result.addFirst(inputArr[i] * 2);
        }

        System.out.println(result);
    }

    private static void lastKseq() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get length");
        int length = sc.nextInt();
        System.out.println("get count");
        int count = sc.nextInt();
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);

        for (int i = 1; i < length; i++) {
            if (result.size() <= count) {
                int sum = 0;

                for (Integer integer : result) {
                    sum += integer;
                }
                result.add(sum);
            } else {
                int sum = 0;
                List<Integer> subL = result.subList(result.size() - count, result.size());

                for (Integer integer : subL) {
                    sum += integer;
                }
                result.add(sum);
            }
        }

        System.out.println(result);

    }

    private static void firstLastK() {
        Scanner sc = new Scanner(System.in);
        System.out.println("getCount");
        int count = Integer.parseInt(sc.nextLine());
        System.out.println("getArr");
        int[] input = Arrays.stream(sc.nextLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        int inputLength = input.length;
        StringBuilder firstLine = new StringBuilder();
        StringBuilder secondLine = new StringBuilder();

        for (int i = 0; i < count; i++) {
            firstLine.append(input[i]).append(" ");
            secondLine.append(input[inputLength - 1 - i]).append(" ");
        }

        System.out.println(firstLine.toString().trim());
        System.out.println(secondLine.reverse().toString().trim());
    }

    private static void rearrange() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get arr");

        int[] inputArr = Arrays.stream(sc.nextLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> result = new ArrayList<Integer>(inputArr.length);

        for (int item : inputArr) {
            if (item < 0) {
                result.addFirst(item);
            } else {
                result.addLast(item);
            }
        }

        for (int item : result) {
            System.out.println(item);
        }
    }

    private static void extractNonDecreasing() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get arr");

        int[] inputArr = Arrays.stream(sc.nextLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(inputArr[0]);
        int currentBiggest = inputArr[0];

        for (int i = 1; i < inputArr.length; i++) {
            int item = inputArr[i];

            if (item > currentBiggest) {
                currentBiggest = item;
                result.add(item);
            }
        }

        System.out.println(result);

    }

    private static void arrayRotate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get arr");
        ArrayList<String> inputArr = new ArrayList<String>(Arrays.asList(sc.nextLine().split(",")));
        int rotations = sc.nextInt() % inputArr.size();

        for (int i = 0; i < rotations; i++) {
            String last = inputArr.removeLast();
            inputArr.addFirst(last);
        }

        System.out.println(inputArr);
    }

    private static void addRemove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("commands");
        String[] commands = sc.nextLine().split(",");
        int startNum = 1;
        List<Integer> result = new ArrayList<Integer>();

        for (String command : commands) {
            switch (command) {
                case "add" -> {
                    result.add(startNum);
                    startNum++;
                }
                case "remove" -> {
                    if (!result.isEmpty()) {
                        result.removeLast();
                    }
                }
            }

        }

        if (result.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        for (int num : result) {
            System.out.printf("%d ", num);
        }

        System.out.printf("\n");
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
