import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        romboid();

    }

    static void romboid() {
        Scanner sc = getScanner("size");
        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            System.out.println("*" + " *".repeat(i));
        }

        for (int i = 0; i <= size -2; i++) {
            System.out.println("*" + " *".repeat(size -2 - i));
        }

    }

    static void square() {
        Scanner sc = getScanner("size");
        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            String row = "*" + " *".repeat(size - 1);
            System.out.println(row);
        }

    }

    static void uniqueCodes() {
        Scanner sc = getScanner("upperLimitFirst");
        int upperLimitFirst = sc.nextInt();
        System.out.println("upperLimitSecond");
        int upperLimitSecond = sc.nextInt();
        System.out.println("upperLimitThird");
        int upperLimitThird = sc.nextInt();

        for (int first = 1; first <= upperLimitFirst; first++) {
            if (first % 2 == 1) {
                continue;
            }

            for (int second = 2; second <= upperLimitSecond; second++) {
                boolean isPrime = primeChecker(second);
                if (!isPrime) {
                    continue;
                }

                for (int third = 1; third <= upperLimitThird; third++) {
                    if (third % 2 == 1) {
                        continue;
                    }

                    System.out.printf("%d %d %d\n", first, second, third);
                }
            }
        }

    }

    static void printPyramid() {
        Scanner sc = getScanner("num");
        int num = sc.nextInt();
        int count = 1;

        for (int i = 1; i <= num; i++) {

            String row = "";

            for (int j = 0; j < i; j++) {
                row = row.concat(count + " ");
                if (count == num) {
                    System.out.println(row);
                    return;
                }
                count++;
            }

            System.out.println(row);

        }
    }

    static void change() {
        Scanner sc = getScanner("resto?");
        float change = Float.parseFloat(sc.nextLine());

        int coinCount = 0;

        double twoLv = Math.floor(change / 2);
        if (twoLv > 0) {
            coinCount += (int) twoLv;
            change -= 2 * ((int) twoLv);
        }

        double oneLv = Math.floor(change);
        if (oneLv > 0) {
            coinCount += (int) oneLv;
            change -= ((int) oneLv);
        }

        double fiftyCent = Math.floor(change / 0.5);
        if (fiftyCent > 0) {
            coinCount += (int) fiftyCent;
            change -= (float) 0.5 * ((int) fiftyCent);
        }

        double twentyCent = Math.floor(change / 0.2);
        if (twentyCent > 0) {
            coinCount += (int) twentyCent;
            change -= (float) 0.2 * ((int) twentyCent);
        }

        double tenCent = Math.floor(change / 0.1);
        if (tenCent > 0) {
            coinCount += (int) tenCent;
            change -= (float) 0.1 * ((int) tenCent);
        }

        double fiveCent = Math.floor(change / 0.05);
        if (fiveCent > 0) {
            coinCount += (int) fiveCent;
            change -= (float) 0.05 * ((int) fiveCent);
        }

        double twoCent = Math.floor(change / 0.02);
        if (twoCent > 0) {
            coinCount += (int) twoCent;
            change -= (float) 0.02 * ((int) twoCent);
        }

        double oneCent = Math.floor(change / 0.01);
        if (oneCent > 0) {
            coinCount += (int) oneCent;
            change -= (float) 0.01 * ((int) oneCent);
        }

        System.out.println(coinCount);

    }

    static void evenPairs() {
        Scanner sc = getScanner("startFirstPair");
        int startFirstPair = sc.nextInt();
        System.out.println("startSecondPair");
        int startSecondPair = sc.nextInt();
        System.out.println("firstPairOffset");
        int firstPairOffset = sc.nextInt();
        System.out.println("secondPairOffset");
        int secondPairOffset = sc.nextInt();

        for (int firstPair = startFirstPair; firstPair <= (startFirstPair + firstPairOffset); firstPair++) {
            boolean firstIsPrime = primeChecker(firstPair);

            if (firstIsPrime) {

                for (int secondPair = startSecondPair; secondPair <= (startSecondPair + secondPairOffset); secondPair++) {
                    boolean secondIsPrime = primeChecker(secondPair);
                    if (secondIsPrime) {
                        System.out.printf("%d%d\n", firstPair, secondPair);
                    }

                }
            }

        }

    }

    static boolean primeChecker(int toCheck) {
        boolean isPrime = true;

        for (int i = 2; i < toCheck; i++) {
            if (toCheck % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    static void coinsAndNotes() {
        Scanner sc = getScanner("1 lv coins count");
        int coinsOneLv = sc.nextInt();
        System.out.println("2 lv coins count");
        int coinsTwoLv = sc.nextInt();
        System.out.println("5 lv coins count");
        int notesFiveLv = sc.nextInt();
        System.out.println("total cost");
        int cost = sc.nextInt();

        for (int oneLvCount = 0; oneLvCount <= coinsOneLv; oneLvCount++) {
            for (int twoLvCount = 0; twoLvCount <= coinsTwoLv; twoLvCount++) {
                for (int fiveLvCount = 0; fiveLvCount <= notesFiveLv; fiveLvCount++) {
                    if ((oneLvCount + twoLvCount * 2 + fiveLvCount * 5) == cost) {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.\n", oneLvCount, twoLvCount, fiveLvCount, cost);
                    }
                }
            }
        }

    }

    static void getEncoding() {
        Scanner sc = getScanner("get Number");
        String inputNum = sc.nextLine();
        int linesToPrint = inputNum.length();

        for (int i = 0; i < linesToPrint; i++) {
            int digit = inputNum.charAt(linesToPrint - 1 - i) - '0';
            char symbol = (char) (digit + 33);

            if (digit == 0) {
                System.out.println("ZERO");
                continue;
            }

            String result = new StringBuffer().append(symbol).toString().repeat(digit);

            System.out.println(result);

        }

    }

    static void printThousandEndingInN() {
        Scanner sc = getScanner("ending num");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = n; i < 1000; i += 10) {
            System.out.println(i);
        }

    }

    static void printThousand() {
        for (int i = 7; i < 1000; i += 10) {
            System.out.println(i);
        }

    }

    static void sumOdds() {
        Scanner sc = getScanner("code");
        int oddCount = Integer.parseInt(sc.nextLine());
        int sum = 0;
//        int runs =0;
//
//
//       while (oddCount > 0) {
//           runs++;
//           if (runs % 2 == 1) {
//               System.out.println(runs);
//               sum += runs;
//               oddCount--;
//           }
//       }
//
//        System.out.printf("Sum: %d", sum);

//        second variant ??

        for (int i = 0; i < oddCount; i++) {
            System.out.println(2 * i + 1);
            sum += (2 * i + 1);
        }
        System.out.printf("Sum: %d%n", sum);
    }

    static void expenses() {
        Scanner sc = getScanner("lostGames, headset, mouse, keyboard, display\n");

        int lostGames = Integer.parseInt(sc.nextLine());
        float headsetPrice = Float.parseFloat(sc.nextLine());
        float mousePrice = Float.parseFloat(sc.nextLine());
        float keyboardPrice = Float.parseFloat(sc.nextLine());
        float displayPrice = Float.parseFloat(sc.nextLine());

        float expenses = 0;

        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0) {
                expenses += headsetPrice;
            }

            if (i % 3 == 0) {
                expenses += mousePrice;
            }

            if (i % 6 == 0) {
                expenses += keyboardPrice;
            }

            if (i % 12 == 0) {
                expenses += displayPrice;
            }
        }

        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }

    static void padawan() {
        Scanner sc = getScanner("budget");
        float budget = Float.parseFloat(sc.nextLine());
        System.out.println("studentCount");
        int studentCount = Integer.parseInt(sc.nextLine());
        System.out.println("swordPrice");
        float swordPrice = Float.parseFloat(sc.nextLine());
        System.out.println("robePrice");
        float robePrice = Float.parseFloat(sc.nextLine());
        System.out.println("beltPrice");
        float beltPrice = Float.parseFloat(sc.nextLine());
        int freeBelts = studentCount / 6;

        System.out.println(freeBelts + "\n");

        float robesTotal = robePrice * studentCount;
        float swordsTotal = (float) (swordPrice * Math.ceil(studentCount * 1.1));
        float beltTotal = beltPrice * (studentCount - freeBelts);

        float total = robesTotal + swordsTotal + beltTotal;

        if (total < budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", total);
        } else {
            float diff = total - budget;
            System.out.printf("George Lucas will need %.2flv more.", diff);
        }
    }

    static void magicNumber() {
        Scanner sc = getScanner("start");
        int start = Integer.parseInt(sc.nextLine());
        System.out.println("end");
        int end = Integer.parseInt(sc.nextLine());
        System.out.println("magic");
        int theMagicNum = Integer.parseInt(sc.nextLine());
        boolean found = false;

        int ranCount = 0;
        for (int first = start; first <= end; first++) {
            for (int second = start; second <= end; second++) {
                ranCount++;
                if (second + first == theMagicNum) {
                    System.out.printf("Combination %d - (%d + %d = %d)\n", ranCount, first, second, theMagicNum);
                    return;
                }
            }
        }

        System.out.printf("%d combinations - neither equals %d\n", ranCount, theMagicNum);
    }

    static void building() {
        Scanner sc = getScanner("floors");
        int floors = Integer.parseInt(sc.nextLine());
        System.out.println("get rooms");
        int rooms = Integer.parseInt(sc.nextLine());

        for (int i = floors; i > 0; i--) {
            String row = "";
            String label = "L";

            if (i != floors && (i % 2) == 0) {
                label = "O";
            } else if (i != floors && (i % 2) == 1) {
                label = "A";
            }

            for (int j = 0; j < rooms; j++) {
                row = row.concat(String.format("%s%d%d ", label, i, j));
            }

            System.out.println(row);
        }

    }

    static void hollowRectangle() {
        Scanner sc = getScanner("row");

        int row = Integer.parseInt(sc.nextLine());
        int col = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < row; i++) {
            String rowToPrint = "";

            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1) {
                    rowToPrint = rowToPrint.concat("*");
                } else if (j == 0 || j == col - 1) {
                    rowToPrint = rowToPrint.concat("*");
                } else {
                    rowToPrint = rowToPrint.concat(" ");
                }

            }

            System.out.println(rowToPrint);
        }
    }

    static Scanner getScanner(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);

        return sc;
    }

}

