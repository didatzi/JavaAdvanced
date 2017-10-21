package Excercise.StringProcessing;

import java.util.Scanner;

public class P04_UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char anInput : input) {
            String tempText = "\\u" + Integer.toHexString(anInput | 0x10000).substring(1);
            stringBuilder.append(tempText);
        }
        System.out.print(stringBuilder.toString());

    }
}
