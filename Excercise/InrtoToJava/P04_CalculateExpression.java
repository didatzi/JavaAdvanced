package Excercise.InrtoToJava;

import java.util.Scanner;

public class P04_CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numA = scanner.nextDouble();
        double numB = scanner.nextDouble();
        double numC = scanner.nextDouble();

        double firstSum = FirstSum(numA, numB, numC);
        double secondSum = SecondSum(numA, numB, numC);
        double difference = Difference(numA, numB, numC, firstSum, secondSum);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", firstSum, secondSum, difference);
    }

    private static double Difference(double numA, double numB, double numC, double firstSum, double secondSum) {
        double avgNumbers = (numA + numB + numC) / 3;
        double avgFunctions = (firstSum + secondSum) / 2;
        return Math.abs(avgNumbers - avgFunctions);
    }

    private static double SecondSum(double numA, double numB, double numC) {
        double function = Math.pow(numA, 2) + Math.pow(numB, 2) - Math.pow(numC, 3);
        double degree = numA - numB;
        return Math.pow(function, degree);
    }

    private static double FirstSum(double numA, double numB, double numC) {
        double degree = (numA + numB + numC) / Math.sqrt(numC);
        double function = (Math.pow(numA, 2) + Math.pow(numB, 2)) / (Math.pow(numA, 2) - Math.pow(numB, 2));

        return Math.pow(function, degree);
    }
}
