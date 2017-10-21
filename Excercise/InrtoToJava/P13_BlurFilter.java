package Excercise.InrtoToJava;

import java.util.Scanner;

public class P13_BlurFilter {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int blurAmount = Integer.parseInt(scanner.nextLine());
        String[] rowsColumns = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsColumns[0]);
        int cols = Integer.parseInt(rowsColumns[1]);

        //fill matrix
        long[][] matrix = new long[rows][cols];
        matrix = fillMatrix(matrix, rows, cols, scanner);

        //manipulate matrix
        String[] position = scanner.nextLine().split(" ");
        int startRow = calcStartPosition(position, "row");
        int startCol = calcStartPosition(position, "col");
        matrix = addBlurFilter(matrix, startRow, startCol, blurAmount);

        //print matrix
        printMatrix(matrix);
    }

    private static long[][] fillMatrix(long[][] matrix, int rows, int cols, Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        return matrix;
    }

    private static void printMatrix(long[][] matrix) {

        for (long[] elementOfMatrix : matrix) {
            for (int j = 0; j < elementOfMatrix.length; j++) {
                String spacer = j == 0 ? "" : " ";
                System.out.print(spacer + elementOfMatrix[j]);
            }
            System.out.println();
        }
    }

    private static long[][] addBlurFilter(long[][] matrix, int startRow, int startCol, int blurAmount) {

        for (int i = startRow; i < startRow + 3; i++) {
            if (i < 0) {
                continue;
            }
            for (int j = startCol; j < startCol + 3; j++) {
                if (j < 0) {
                    continue;
                }
                try {
                    matrix[i][j] += blurAmount;
                }catch (Exception e){

                }
            }
        }
        return matrix;
    }

    private static int calcStartPosition(String[] position, String type) {
        int index = type.equals("row") ? 0 : 1;
        return Integer.parseInt(position[index]) - 1;
    }
}
