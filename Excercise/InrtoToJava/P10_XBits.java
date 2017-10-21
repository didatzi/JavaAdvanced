package Excercise.InrtoToJava;

import java.util.Scanner;

public class P10_XBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] binaryNumbers = new String[8];
        for (int i = 0; i < binaryNumbers.length; i++) {
            int inputNumber = Integer.parseInt(scanner.nextLine());
            String binaryString = String.format("%32s", Integer.toBinaryString(inputNumber)).replace(" ", "0");
            binaryNumbers[i] = binaryString;
        }
        int counter = 0;
        for (int i = 0; i < binaryNumbers.length - 2; i++) {
            for (int j = 0; j < binaryNumbers[i].length() - 2; j++) {
                String a = binaryNumbers[i].charAt(j) + "" + binaryNumbers[i].charAt(j + 1) + "" + binaryNumbers[i].charAt(j + 2);
                String b = binaryNumbers[i + 1].charAt(j) + "" + binaryNumbers[i + 1].charAt(j + 1) + "" + binaryNumbers[i + 1].charAt(j + 2);
                String c = binaryNumbers[i + 2].charAt(j) + "" + binaryNumbers[i + 2].charAt(j + 1) + "" + binaryNumbers[i + 2].charAt(j + 2);
                if (a.equals("101") && b.equals("010") && c.equals("101")) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
