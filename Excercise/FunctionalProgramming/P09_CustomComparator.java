package Excercise.FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class P09_CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        Function<int[], int[]> customSort = n -> {
            int[] customSorted = new int[n.length];

            ArrayList<Integer> evenNums = new ArrayList<>();
            ArrayList<Integer> oddNums = new ArrayList<>();

            for (int i : n) {
                if (i % 2 == 0)
                    evenNums.add(i);
                else
                    oddNums.add(i);
            }

            Collections.sort(evenNums);
            Collections.sort(oddNums);

            int i = 0;
            for (Integer evenNum : evenNums) {
                customSorted[i++] = evenNum;
            }

            for (Integer oddNum : oddNums) {
                customSorted[i++] = oddNum;
            }
            return customSorted;
        };

        int[] sorted = customSort.apply(numbers);
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
}
