import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        building();

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

