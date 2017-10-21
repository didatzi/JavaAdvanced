package Excercise.InrtoToJava;

import java.util.Scanner;

public class P02_TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aX = scanner.nextInt();
        int aY = scanner.nextInt();
        scanner.nextLine();
        int bX = scanner.nextInt();
        int bY = scanner.nextInt();
        scanner.nextLine();
        int cX = scanner.nextInt();
        int cY = scanner.nextInt();

        double area = (aX*(bY-cY)+bX*(cY-aY)+cX*(aY-bY))/2;
        area = Math.abs(area);
        System.out.printf("%.0f",area);
    }
}
