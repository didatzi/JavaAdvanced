package Excercise.InrtoToJava;

import java.util.Scanner;

public class P01_RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sideA = scanner.nextDouble();
        double sideB = scanner.nextDouble();

        double sum = sideA * sideB;
        System.out.printf("%.2f", sum);
    }
}
