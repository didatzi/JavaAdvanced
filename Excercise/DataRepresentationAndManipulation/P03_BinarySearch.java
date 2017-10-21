package Excercise.DataRepresentationAndManipulation;

import java.util.Arrays;
import java.util.Scanner;

public class P03_BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println(rank(key, arr));
    }

    private static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    private static int rank(int key, int[] a, int lo, int hi) {
        // Index of key in a[], if present, is not smaller than lo
        // and not larger than hi.
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi);
        } else return mid;
    }
}
