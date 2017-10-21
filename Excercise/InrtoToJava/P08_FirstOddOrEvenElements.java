package Excercise.InrtoToJava;

import java.util.Scanner;

public class P08_FirstOddOrEvenElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] stringNumbers = scanner.nextLine().split(" ");
        String[] inputCommand = scanner.nextLine().split(" ");

        StringBuilder output = new StringBuilder();
        int outputElements = Integer.parseInt(inputCommand[1]);
        String numberType = inputCommand[2];

        for (String numberStr : stringNumbers) {
            if (outputElements < 1) {
                break;
            }
            int currentNumber = Integer.parseInt(numberStr);
            String space = output.length() > 0 ? " " : "";
            if (numberType.equals("even") && currentNumber % 2 == 0) {
                output.append(space).append(currentNumber);
                outputElements--;
            } else if (numberType.equals("odd") && currentNumber % 2 != 0) {
                output.append(space).append(currentNumber);
                outputElements--;
            }
        }
        System.out.println(output);
    }
}
