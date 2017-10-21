package Lab.DataRepresentationAndManipulation;

import java.util.Scanner;

public class P01_Sorting {
    static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbersStr = scanner.nextLine().split("\\s+");
        arr = new int[numbersStr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(numbersStr[i]);
        }

        bubbleSort();
//        selectionSort();
        printArr();
    }

    private static void bubbleSort() {
        boolean swapped;
        do {
            swapped = false;
            for (int index = 0; index < arr.length - 1; index++) {
                if (arr[index] > arr[index + 1]) {
                    swap(index, index + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static void printArr() {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static void selectionSort() {
        for (int index = 0; index < arr.length; index++) {
            int minNumber = index;
            for (int currentNum = index + 1; currentNum < arr.length; currentNum++) {
                if (arr[currentNum] < arr[minNumber]) {
                    minNumber = currentNum;
                }
            }
            swap(index, minNumber);
        }
    }

    private static void swap(int index, int minNumber) {
        int temp = arr[index];
        arr[index] = arr[minNumber];
        arr[minNumber] = temp;
    }
}
