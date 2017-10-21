package Excercise.ObjectsClassesAndCollections;

import java.util.*;
import java.util.stream.IntStream;

public class P03_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputCommands = scanner.nextLine().split("\\s+");

        Integer numbersForPush = Integer.valueOf(inputCommands[0]);
        Integer numbersForPop = Integer.valueOf(inputCommands[1]);
        Integer numberForCheck = Integer.valueOf(inputCommands[2]);
        Integer[] inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::valueOf).toArray(Integer[]::new);

        Deque<Integer> numbers = new ArrayDeque<>();
        //from for cycle into one line foreach
        numbers.addAll(Arrays.asList(inputNumbers).subList(0, numbersForPush));

        //on one line stream with foreach function
        IntStream.range(0, numbersForPop).forEach(i -> numbers.poll());
//        for (int i = 0; i < numbersForPop; i++) {
//            numbers.poll();
//        }
        if (!numbers.contains(numberForCheck)) {
            if (numbers.size() == 0) {
                System.out.println(numbers.size());
            } else {
                System.out.println(Collections.min(numbers));
            }
        } else
            System.out.println("true");
    }
}
