package Excercise.Abstraction;

import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        fillMatrix(scanner, matrix);

        printingMatrix(matrix, size);
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            String[] temp = scanner.nextLine().split("\\s+");
            for (int j = 0; j < matrix.length; j++) {
                int number = Integer.parseInt(temp[j]);
                matrix[i][j] = number;
            }
        }
    }

    private static void printingMatrix(int[][] matrix, int col) {
        int primarySum = 0;
        int secondarySum = 0;
        for (int row = 0; row < col; row++) {
            primarySum += matrix[row][row];
            secondarySum += matrix[row][col - 1 - row];
        }
        System.out.println(Math.abs(primarySum - secondarySum));
    }
}
