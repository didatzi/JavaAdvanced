package Lab.DataRepresentationAndManipulation;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class P02_Searching {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(elements);
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println(binarySearch(elements, key));
    }

    private static int binarySearch(int[] elements, int key) {
        int lowNumber = 0;
        int highNumber = elements.length;
        while (lowNumber < highNumber) {
            int middleNumber = (lowNumber + highNumber) / 2;
            if (key < elements[middleNumber]) {
                highNumber = middleNumber - 1;
            } else if (key > elements[middleNumber]) {
                lowNumber = middleNumber + 1;
            } else {
                return middleNumber;
            }
        }
        return -1;
    }
}
