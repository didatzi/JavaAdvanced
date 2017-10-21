package Lab.FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Function;

public class P02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        Function<String, Integer> parserFunc = str -> Integer.parseInt(str);
        int sum =0;
        for (int i = 0; i < input.length; i++) {
           sum += parserFunc.apply(input[i]);
        }
        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);
    }
}
