package Lab.Abstraction;

import java.util.Scanner;

public class P04_MaximumSum2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixSize = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        int[][] matrix = new int[rows][cols];
        //fill rows of the matrix
        for (int row = 0; row < matrix.length; row++) {
            //fill colons of the matrix
            String[] reminder = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(reminder[col]);
            }
        }

        int bestSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultCol = 0;
        //read matrix
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                //store the best sum of the 2x2 matrix
                if (bestSum < sum) {
                    bestSum = sum;
                    //store the original value of indexes in matrix
                    resultRow = row;
                    resultCol = col;
                }
            }
        }
        //print the matrix by index and best sum
        System.out.println(matrix[resultRow][resultCol] +" "+ matrix[resultRow][resultCol + 1]);
        System.out.println(matrix[resultRow + 1][resultCol] +" "+ matrix[resultRow + 1][resultCol + 1]);
        System.out.println(bestSum);
    }
}
