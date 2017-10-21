package Excercise.Abstraction;

import java.util.Scanner;

public class P07_CollectTheCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //fill the matrix
        char[][] matrix = getCharMatrix(scanner);
        //read the moves
        char[] moves = scanner.nextLine().toCharArray();

        int currentRow = 0;
        int currentCol = 0;
        int coins = 0;
        int wallsHit = 0;

        if (matrix[currentRow][currentCol] == '$') {
            coins++;
        }

        for (char move : moves) {
            int copyRow = currentRow;
            int copyCol = currentCol;

            switch (move) {
                case '^':
                    currentRow--;
                    break;
                case '>':
                    currentCol++;
                    break;
                case 'V':
                    currentRow++;
                    break;
                case '<':
                    currentCol--;
                    break;
            }
            boolean isInMatrix = currentRow >= 0
                              && currentCol >= 0
                              && currentRow < 4
                              && currentCol < matrix[currentRow].length;
            if (!isInMatrix) {
                currentRow = copyRow;
                currentCol = copyCol;
                wallsHit++;
            } else {
                if (matrix[currentRow][currentCol] == '$')
                    coins++;
            }
        }

        System.out.println("Coins = " + coins);
        System.out.println("Walls = " + wallsHit);
    }

    private static char[][] getCharMatrix(Scanner scanner) {
        char[][] matrix = new char[4][];
        for (int i = 0; i < 4; i++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            matrix[i] = new char[currentRow.length];
            // copy arr into new one
            System.arraycopy(currentRow, 0, matrix[i], 0, currentRow.length);
        }
        return matrix;
    }
}
