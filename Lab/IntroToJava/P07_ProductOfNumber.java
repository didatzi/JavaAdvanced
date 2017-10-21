package Lab.IntroToJava;

import java.math.BigInteger;
import java.util.Scanner;

public class P07_ProductOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BigInteger product = BigInteger.ONE;
        int counter = n;

        do {
            BigInteger number = new BigInteger("" + counter);
            product = product.multiply(number);
            counter++;
        } while (counter <= m);

        System.out.printf("product[%d..%d] = %d", n, m, product);
    }
}
