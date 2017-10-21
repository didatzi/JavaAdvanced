package Excercise.InrtoToJava;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P03_FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        String hexNum = Integer.toHexString(a).toUpperCase();
        String hexWithSpaces = String.format("%-10s", hexNum);
        String binaryNum = Integer.toBinaryString(a);
        String binaryWithSpaces = String.format("%10s", binaryNum).replace(' ', '0');
        DecimalFormat formatB = new DecimalFormat("0.00");
        DecimalFormat formatC = new DecimalFormat("0.000");
        String padRightB = String.format("%10s", formatB.format(b));
        String padLeftC = String.format("%-10s", formatC.format(c));
        System.out.printf("|%s|%s|%s|%s|", hexWithSpaces, binaryWithSpaces, padRightB, padLeftC);

    }
}
