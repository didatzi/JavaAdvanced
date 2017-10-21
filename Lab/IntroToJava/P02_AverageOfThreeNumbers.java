package Lab.IntroToJava;

import java.util.Scanner;

public class P02_AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNum = scanner.nextDouble();
        double secondNum = scanner.nextDouble();
        double thirdNum = scanner.nextDouble();
        double sumOfThree = firstNum + secondNum + thirdNum;
        double average = sumOfThree / 3;
        System.out.printf("%.2f", average);
    }
}
