package Lab.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class P03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split("\\s+");

        Predicate<String> checkerForUpperCase = str -> Character.isUpperCase(str.charAt(0));

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            if (checkerForUpperCase.test(text[i])) {
                result.add(text[i]);
            }
        }
        System.out.println(result.size());
        for (String word : result) {
            System.out.println(word);
        }
    }
}
