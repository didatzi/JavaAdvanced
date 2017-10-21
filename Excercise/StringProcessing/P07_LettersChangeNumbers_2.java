package Excercise.StringProcessing;

import java.util.Scanner;

public class P07_LettersChangeNumbers_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] inputArguments = in.nextLine().split("\\s+");
        double totalResult = 0;
        for (String inputArgument : inputArguments) {
            char firstChar = inputArgument.charAt(0);
            char lastChar = inputArgument.charAt(inputArgument.length() - 1);
            double number = Double.parseDouble(inputArgument.substring(1, inputArgument.length() - 1));

            if (Character.toString(firstChar).equals(Character.toString(firstChar).toLowerCase())) {
                number *= firstChar - 96;
            } else {
                number /= firstChar - 64;
            }

            if (Character.toString(lastChar).equals(Character.toString(lastChar).toLowerCase())) {
                number += lastChar - 96;
            } else {
                number -= lastChar - 64;
            }

            totalResult += number;
        }

        System.out.printf("%.2f\n", totalResult);
    }
}
