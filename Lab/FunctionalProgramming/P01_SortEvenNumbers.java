package Lab.FunctionalProgramming;

import java.util.*;

public class P01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //TODO: Read numbers and parse them to List Of Integers
        List<Integer> numbers = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\s*,\\s*");
        for (String index : input) {

            numbers.add(Integer.parseInt(index));
        }
        // lambda expression;
        numbers.removeIf(n -> n % 2 != 0);

        // TODO: Print the even numbers
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));

        //  numbers.sort((a, b) -> a.compareTo(b));
        numbers.sort(Integer::compareTo);

        //TODO: Print the sorted numbers
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));

    }
}
