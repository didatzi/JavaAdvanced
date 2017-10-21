package Lab.StringProcessing;

import java.util.Scanner;

public class P01_StudentsResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|\n",
                "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        String input = scan.nextLine();

        String[] currentRow = input.split("-");
        String name = currentRow[0];
        String[] digits = currentRow[1].split(", ");

        double javaAdv = Double.parseDouble(digits[0]);
        double oop = Double.parseDouble(digits[1]);
        double advOop = Double.parseDouble(digits[2]);
        double average = (javaAdv + oop + advOop) / 3;

        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|\n",
                name, javaAdv, oop, advOop, average);
    }
}
