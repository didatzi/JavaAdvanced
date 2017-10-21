package Excercise.StringProcessing;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P05_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split("[\\s,.?!]+");
        Set<String> palindromes = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word : text) {
            sb.append(word);
            String reversedWord = sb.reverse().toString();
            if (reversedWord.equals(word)){
                palindromes.add(word);
            }
            sb.delete(0,word.length());
        }
        System.out.println(palindromes);
    }
}
