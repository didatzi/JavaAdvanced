package Excercise.FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;

public class P03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
          //read Integer[] in one line;
//        Integer[] n = Arrays.stream
//                (Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray())
//                .boxed()
//                .toArray(Integer[]::new);
        String[] input = scanner.nextLine().split("\\s+");
        Integer[] numbers = new Integer[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        Function<Integer[], Integer> minNumber = nums -> Collections.min(Arrays.asList(nums));

        System.out.println(minNumber.apply(numbers));
    }
}
