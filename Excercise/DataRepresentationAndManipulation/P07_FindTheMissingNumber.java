package Excercise.DataRepresentationAndManipulation;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P07_FindTheMissingNumber { // 100/100
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer n = Integer.parseInt(scan.nextLine());
        String[] area = scan.nextLine().split(", ");
        Set<Integer> set = new TreeSet<>();

        for (String anArea : area) {
            set.add(Integer.parseInt(anArea));
        }

        boolean isSearched = true;
        Integer missingInteger = 0;

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                missingInteger = i;
                isSearched = false;
            }
        }
        System.out.printf("%d", missingInteger);
    }
}