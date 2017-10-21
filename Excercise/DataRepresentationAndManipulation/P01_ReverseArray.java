package Excercise.DataRepresentationAndManipulation;

import java.util.Arrays;
import java.util.Scanner;

public class P01_ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

//        reverseArr(data);
        reverseRecursion(data, 0, data.length-1);
        printArr(data);
    }

    private static void printArr(int[] data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int anArr : data) {
            stringBuilder.append(anArr).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }
    private static void reverseRecursion(int[] data, int leftSide, int rightSide){

        if (leftSide < rightSide){
            int temp = data[leftSide];
            data[leftSide] = data[rightSide];
            data[rightSide] = temp;
            reverseRecursion(data, ++leftSide, --rightSide);
        }
    }
//    private static void reverseArr(int[] data) {
//        int left = 0;
//        int right = data.length - 1;
//
//        while( left < right ) {
//            // swap the values at the left and right indices
//            int temp = data[left];
//            data[left] = data[right];
//            data[right] = temp;
//
//            // move the left and right index pointers in toward the center
//            left++;
//            right--;
//        }
//    }

}
