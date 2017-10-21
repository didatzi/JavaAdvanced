package Excercise.StringProcessing;

import java.util.Scanner;

public class P03_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banWords = scanner.nextLine().split(",");

        String text = scanner.nextLine();

        for (String banWord : banWords) {
            banWord = banWord.trim();
            if (text.contains(banWord)) {
                String banWordReplacement = repeat(banWord.length());
                text = text.replaceAll(banWord, banWordReplacement);
            }
        }
        System.out.println(text);
    }
    private static String repeat(int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += "*";
        }
        return text;
    }
}
