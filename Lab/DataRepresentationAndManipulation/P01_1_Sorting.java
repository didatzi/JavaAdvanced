package Lab.DataRepresentationAndManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_1_Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (int element : arr) {
            stringBuilder.append(element).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }
}
