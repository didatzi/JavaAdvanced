package Excercise.DataRepresentationAndManipulation;

import java.util.Scanner;
import java.util.TreeMap;

public class P06_OverlappingIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<Integer, Integer> tm = new TreeMap<>();

        boolean isFound = false;

        for (int i = 0; i < n; i++) {
            String[] start = scanner.nextLine().split(",");
            int key = Integer.parseInt(start[0]);
            int value = Integer.parseInt(start[1]);

            tm.put(key, value);
        }

        for (int i = 0; i < tm.size() - 1; i++) {

            int currentKey = (int) tm.keySet().toArray()[i];
            int currentValue = tm.get(currentKey);
            int nextKey = (int) tm.keySet().toArray()[i + 1];

            if (currentKey <= nextKey && nextKey <= currentValue) {
                isFound = true;
                break;
            }
        }
        System.out.print(isFound);
    }
}
