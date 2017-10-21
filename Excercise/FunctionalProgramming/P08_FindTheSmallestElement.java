package Excercise.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P08_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        Function<List<Integer>, Integer> minNumber = num -> findIndexOfSmallestNum(num);

                System.out.println(minNumber.apply(numbers));
    }

    private static Integer findIndexOfSmallestNum(List<Integer> nums) {
        int number = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            if (num <= number) {
                number = num;
            }
        }
        return nums.lastIndexOf(number);
    }
}
