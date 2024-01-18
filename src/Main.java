import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("get input");

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

}

