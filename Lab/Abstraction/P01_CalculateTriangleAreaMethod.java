package Lab.Abstraction;

import java.util.Scanner;

public class P01_CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();
        double area = calcTriangleArea(width, height);
        System.out.printf("Area = %.2f", area);
    }

    private static double calcTriangleArea(double wigth, double hight) {
        return wigth * hight / 2;
    }
}
