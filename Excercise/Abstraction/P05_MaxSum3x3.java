package Excercise.Abstraction;

import java.util.Scanner;

public class P05_MaxSum3x3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        int[][] matrix = new int[rows][cols];


//        for (int i = 0; i < matrixSize.length; i++) {

        //read and parse int from console on one line
//        matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        }
        fillMatrix(scanner, rows, cols, matrix);

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);

        printMatrix(matrix, startRow, startCol);
    }

    private static void printMatrix(int[][] matrix, int startRow, int startCol) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf(matrix[startRow + i][startCol + j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int rows, int cols, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            String[] currentLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(currentLine[j]);
            }
        }
    }
}
