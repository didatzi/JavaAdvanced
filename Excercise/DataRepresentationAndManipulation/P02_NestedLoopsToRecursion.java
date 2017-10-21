package Excercise.DataRepresentationAndManipulation;

import java.util.Scanner;

public class P02_NestedLoopsToRecursion {
    private static int numberOfLoops;
    private static int[] loops;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numberOfLoops = Integer.parseInt(scanner.nextLine());
        loops = new int[numberOfLoops];
        simulateLoop(0);

//        int[] length = new int[depth];
//        int[] counters = new int[depth];
//
//        nestedLoopOperation(counters, length, 0);
//    }
//
//   private static void nestedLoopOperation(int[] counters, int[] length, int currentValue) {
//        if(currentValue == counters.length) {
//            performOperation(counters);
//        }
//        else {
//            for (counters[currentValue] = 0; counters[currentValue] < length.length; counters[currentValue]++){
//                nestedLoopOperation(counters, length, currentValue + 1);
//            }
//        }
//    }
//    //fill and print the lines
//    private static void performOperation(int[] counters) {
//       StringBuilder counterAsString = new StringBuilder();
//        for (int level = 0; level < counters.length; level++) {
//            counterAsString.append(1 + counters[level]);
//            if (level < counters.length - 1) {
//                counterAsString.append(" ");
//            }
//        }
//        System.out.println(counterAsString);
    }

    private static void simulateLoop(int number) {

    }
}