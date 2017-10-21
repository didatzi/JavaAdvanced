package Excercise.DataRepresentationAndManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P05_Chocolates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int barSize = Integer.parseInt(scanner.nextLine());

        List<Integer> list = new ArrayList<>();
        String[] input = scanner.nextLine().split(", ");

        for (String anInput : input) {
            list.add(Integer.parseInt(anInput));
        }

        int minStudents = Integer.parseInt(scanner.nextLine());
        Collections.sort(list);

        int min = 0;
        int max = 0;

        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i < barSize; i++) {

            if (i + minStudents - 1 < list.size()) {
                min = list.get(i);
                max = list.get(i + minStudents - 1);

                if (max - min < minDifference) {
                    minDifference = max - min;
                }
            }
        }
        System.out.printf("Min Difference is %s.", minDifference);
    }
}
