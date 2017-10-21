package Lab.FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Function;

public class P04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        Function<String, Double> addVat = str -> Double.parseDouble(str) * 1.2;
        System.out.println("Prices with VAT:");
        for (String element : input) {
            System.out.println((String.format("%.2f", addVat.apply(element))).replace('.', ','));
        }
    }
}
