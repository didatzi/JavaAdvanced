package Lab.Abstraction;

import java.util.Scanner;

public class P03_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixSize = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        System.out.println(rows);
        System.out.println(cols);

        int[][] matrix = new int[rows][cols];
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            String[] reminder = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Integer.parseInt(reminder[col]);
                sum += matrix[row][col];
            }
        }
        System.out.println(sum);
    }
}
