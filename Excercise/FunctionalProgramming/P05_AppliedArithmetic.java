package Excercise.FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P05_AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        Integer[] numbers = Arrays.stream(scan.readLine().split("\\s+")).map(Integer::valueOf).toArray(Integer[]::new);
        while (true) {
            String command = scan.readLine().toLowerCase();
            if (command.equals("end")) {
                break;
            }
            switch (command) {
                case "add":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = operation(numbers[i], num -> num + 1);
                    }
                    break;
                case "multiply":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = operation(numbers[i], num -> num * 2);
                    }
                    break;
                case "subtract":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = operation(numbers[i], num -> num - 1);
                    }
                    break;
                case "print":
                    for (Integer number : numbers) {
                        System.out.print(number + " ");
                    }
                    System.out.println();
                    break;
            }
        }
    }
    private static int operation ( int number, Function<Integer, Integer > function){
        return function.apply(number);
    }
}
