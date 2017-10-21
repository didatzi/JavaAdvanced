package Excercise.DataRepresentationAndManipulation;

import java.util.Arrays;
import java.util.Scanner;

public class P06_OverlappingIntervals_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] pairs = new String[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = scan.nextLine();
        }
        Arrays.sort(pairs);
        boolean overlap = false;

        int[] first = new int[2];
        int[] second = new int[2];
        for (int i = 0; i < pairs.length - 1; i++) {
            first = Arrays.stream(pairs[i].split(",")).mapToInt(Integer::parseInt).toArray();
            second = Arrays.stream(pairs[i + 1].split(",")).mapToInt(Integer::parseInt).toArray();
            if (second[0] >= first[0] && second[0] <= first[1] || second[1] <= first[1] && second[1] >= first[0]) {
                overlap = true;
                break;
            }

        }

        System.out.println(overlap);
    }
}
