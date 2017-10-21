package Lab.IntroToJava;

import java.util.Scanner;

public class P10_ModifyABit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int position = scanner.nextInt();
        int binaryValue = scanner.nextInt();

        int mask = 1 << position;
        int result = 0;
        if (binaryValue == 0) {
            mask = ~mask;
            result = number & mask;
        }
        if (binaryValue == 1) {
            result = number | mask;
        }
        System.out.println(result);
    }
}
