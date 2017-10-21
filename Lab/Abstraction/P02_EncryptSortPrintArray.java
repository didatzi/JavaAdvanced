package Lab.Abstraction;

import java.util.*;

public class P02_EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> vowel = new ArrayList<>(Arrays.asList('a', 'e', 'o', 'i', 'u','A', 'E', 'O', 'I', 'U' ));

        int num = Integer.valueOf(scanner.nextLine());
        int[] sumOfCharacters = new int[num];

        for (int i = 0; i < num; i++) {
            int currentSum = 0;
            String input = scanner.nextLine();
            int inputLength = input.length();

            for (char element : input.toCharArray()) {
                if (vowel.contains(element)) {
                    currentSum += inputLength * (int) element;
                } else {
                    currentSum += (int) element / inputLength ;
                }
            }
            sumOfCharacters[i] = currentSum;
        }
        Arrays.sort(sumOfCharacters);

        for (int sum : sumOfCharacters) {
            System.out.println(sum);
        }
    }
}
