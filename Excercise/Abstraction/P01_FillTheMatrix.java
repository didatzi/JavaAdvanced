package Excercise.Abstraction;

import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        char matrixPattern = input[1].toUpperCase().charAt(0);
        int[][] matrix = new int[n][n];


        switch (matrixPattern) {
            case 'A':
                firstPattern(matrix);
                break;
            case 'B':
                secondPattern(matrix);
                break;
            default:
                break;
        }
        printingMatrix(matrix);
    }

    private static void printingMatrix(int[][] matrix) {
        for (int[] element : matrix) {
            for (int i = 0; i < matrix[0].length; i++) {
                System.out.print(element[i] + " ");
            }
            System.out.println();
        }
    }

    private static void secondPattern(int[][] matrix) {
        int counter = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 != 0) {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    matrix[j][i] = counter;
                    counter++;
                }
            } else {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[j][i] = counter;
                    counter++;
                }
            }
        }
    }

    private static void firstPattern(int[][] matrix) {
        int counter = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = counter;
                counter++;
            }
        }
    }
}
