package Excercise.InrtoToJava;

import java.util.Scanner;

public class P05_EvenOddPairs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String numbers = scanner.nextLine();
        String[] onlyNumbers = numbers.split(" ");

        if (onlyNumbers.length % 2 != 0) {
            System.out.println("invalid length");
        } else {
            for (int i = 0; i < onlyNumbers.length; i += 2) {

                int firstNumber = Integer.parseInt(onlyNumbers[i]);
                int secondNumber = Integer.parseInt(onlyNumbers[i + 1]);

                if (firstNumber % 2 == 0 && secondNumber % 2 == 0) {
                    System.out.printf("%d, %d -> both are even%n", firstNumber, secondNumber);
                } else if (firstNumber % 2 != 0 && secondNumber % 2 != 0) {
                    System.out.printf("%d, %d -> both are odd%n", firstNumber, secondNumber);
                } else {
                    System.out.printf("%d, %d -> different%n", firstNumber, secondNumber);
                }
            }
        }
    }

}
