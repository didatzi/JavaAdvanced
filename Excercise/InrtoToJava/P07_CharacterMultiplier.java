package Excercise.InrtoToJava;

import java.util.Scanner;

public class P07_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        String firstWord = tokens[0];
        String secondWord = tokens[1];

        int sum = 0;
        int minLength = Math.min(firstWord.length(), secondWord.length());
        for (int i = 0; i < minLength; i++) {
            sum += firstWord.charAt(i) * secondWord.charAt(i);
        }
        String longerWord  = firstWord.length() > secondWord.length() ? firstWord:secondWord;
        for (int i = minLength; i < longerWord.length(); i++) {
            sum += longerWord.charAt(i);
        }

        System.out.println(sum);
    }
}
