package Excercise.Abstraction;

import java.util.Scanner;

public class P04_2x2SquaresMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currentRow = scan.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = currentRow[col];
            }
        }
        int counter = 0;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                if (matrix[row][col].equals(matrix[row][col + 1])
                        && matrix[row][col].equals(matrix[row + 1][col])
                        && matrix[row][col].equals(matrix[row + 1][col + 1])) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
