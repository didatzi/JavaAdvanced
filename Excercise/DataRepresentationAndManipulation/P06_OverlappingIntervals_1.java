package Excercise.DataRepresentationAndManipulation;

import java.util.Scanner;

public class P06_OverlappingIntervals_1 {
    private static class Interval {
        private int start;
        private int end;

        private Interval(String interval) {
            String[] items = interval.split(",", -1);
            start = Integer.parseInt(items[0]);
            end = Integer.parseInt(items[1]);
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            String line = console.nextLine();
            Interval newStudent = new Interval(line);
            arr[i] = newStudent;
        }

        boolean hasOverlap = findOverlappingIntervals(arr);

        System.out.println(hasOverlap);
    }

    private static boolean findOverlappingIntervals(Interval[] arr) {
        boolean hasOverlap = false;

        for (int i = 0; i < arr.length - 1 && !hasOverlap; i++) {
            for (int j = i + 1; j < arr.length && !hasOverlap; j++) {
                if (arr[i].start <= arr[j].start && arr[j].start <= arr[i].end
                        || arr[i].start <= arr[j].end && arr[j].end <= arr[i].end) {
                    hasOverlap = true;
                }
            }
        }

        return hasOverlap;
    }
}
