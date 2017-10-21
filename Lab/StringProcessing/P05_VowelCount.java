package Lab.StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_VowelCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern p = Pattern.compile("[AaOoEeIiUuYy]");
        Matcher matcher = p.matcher(input);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        System.out.println("Vowels: " + count);
    }
}
