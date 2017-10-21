package Excercise.ObjectsClassesAndCollections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P01_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputCommands = scanner.nextLine().split("\\s+");

        Integer numbersForPush = Integer.valueOf(inputCommands[0]);
        Integer numbersForPop = Integer.valueOf(inputCommands[1]);
        Integer numberForCheck = Integer.valueOf(inputCommands[2]);
        Integer[] inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::valueOf).toArray(Integer[]::new);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < numbersForPush; i++) {
            numbers.push(inputNumbers[i]);
        }
        for (int i = 0; i < numbersForPop; i++) {
            numbers.pop();
        }
        if (numbers.contains(numberForCheck)) {
            System.out.println("true");
        } else {
            if (numbers.size() == 0) {
                System.out.println(numbers.size());
            } else {

                System.out.println(Collections.min(numbers));
            }
        }

    }
}
