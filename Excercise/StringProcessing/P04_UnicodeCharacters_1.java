package Excercise.StringProcessing;

import java.util.Scanner;

public class P04_UnicodeCharacters_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] input = scan.nextLine().toCharArray();
        for (char ch : input) {

            String unicode = toUnicode(ch);

            System.out.printf("%s", unicode);
        }
    }

    private static String toUnicode(char ch) {
        return String.format("\\u%04x", (int) ch);
    }
}
