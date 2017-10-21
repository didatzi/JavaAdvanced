package Excercise.InrtoToJava;

import java.util.Scanner;

public class P06_HitTheTarget {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();

        for (int numA = 1; numA <= 20; numA++) {
            for (int numB = 1; numB <= 20; numB++) {
                if (numA + numB == target) {
                    System.out.printf("%d + %d = %d%n", numA, numB, target);
                }
                if (numA - numB == target) {
                    System.out.printf("%d - %d = %d%n", numA, numB, target);
                }
            }
        }
    }
}
