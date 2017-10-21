package Excercise.FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;

public class P04_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String evenOrOdd = scanner.nextLine().toLowerCase();
        Predicate<Integer> isEven = num -> num % 2 == 0;

        System.out.println(evenOdd(numbers, isEven, evenOrOdd));

    }

    private static String evenOdd(int[] numbers, Predicate<Integer> isEven, String evenOrOdd) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();
        int startIndex = numbers[0];
        int endIndex = numbers[1];
        for (int i = startIndex; i <= endIndex; i++) {
            if (isEven.test(i)) {
                even.append(i).append(" ");
            } else {
                odd.append(i).append(" ");
            }
        }
        switch (evenOrOdd) {
            case "even":
                return even.toString().trim();
            case "odd":
                return odd.toString().trim();
        }
        return "";
    }
}
