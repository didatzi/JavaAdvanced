package Lab.DataRepresentationAndManipulation;

import java.util.Arrays;
import java.util.Scanner;

public class P03_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //call the recurse
        System.out.println(sum(numbers,0));
    }

    //recursion method
    private static int sum(int[] arr, int index){
       //base
        if (index == arr.length-1){
            return arr[index];
        }
        //recursive calls
        return arr[index] + sum(arr, index+1);
    }
}
