package Excercise.Abstraction;

import java.util.Scanner;

public class P02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        String[][] matrix = new String[rows][cols];

        fillTheMatrix(matrix);

        printingMatrix(matrix);
    }

    private static void fillTheMatrix(String[][] matrix) {
        char row = 'a';
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = row+"" + (char)(row + j)+"" + row +"";
            }
            row++;
        }
    }

    private static void printingMatrix(String[][] matrix) {
        for (String[] element : matrix) {
            for (int i = 0; i < matrix[0].length; i++) {
                System.out.print(element[i] + " ");
            }
            System.out.println();
        }
    }
}
