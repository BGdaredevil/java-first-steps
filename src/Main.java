import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        magicNumber();
    }

    static void magicNumber() {
        Scanner sc = getScanner();
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
        Scanner sc = getScanner();
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
        Scanner sc = getScanner();

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

    static Scanner getScanner() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get input");

        return sc;
    }

}

