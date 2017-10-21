package Excercise.Abstraction;

import java.util.Arrays;
import java.util.Scanner;

public class P08_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //set matrix
        int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = matrixSize[0];
        int col = matrixSize[1];
        String[][] matrix = new String[row][col];

        //fill matrix
        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
        while (true) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens[0].equals("END")) {
                break;
            }
            if (tokens[0].equals("swap") && tokens.length == 5) {

                int startRow = Integer.parseInt(tokens[1]);
                int startColumn = Integer.parseInt(tokens[2]);
                int endRow = Integer.parseInt(tokens[3]);
                int endColumn = Integer.parseInt(tokens[4]);

                if (startRow > row || endRow > row || startColumn > col || endColumn > col) {
                    System.out.printf("Invalid input!\n");
                } else {
                    String temp = "";

                    temp = matrix[startRow][startColumn];
                    matrix[startRow][startColumn] = matrix[endRow][endColumn];
                    matrix[endRow][endColumn] = temp;

                    printMatrix(matrix);
                }

            } else {
                System.out.printf("Invalid input!\n");
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(aMatrix[j] + " ");
            }
            System.out.println();
        }
    }
}


//        2 3
//        1 2 3
//        4 5 6
//        swap 0 0 1 1
//        swap 10 9 8 7
//        swap 0 1 1 0
//        END
