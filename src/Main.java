import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        sumOdds();

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

