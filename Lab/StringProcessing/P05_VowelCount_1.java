package Lab.StringProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05_VowelCount_1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int counter = 0;
        char[] input = scan.nextLine().toLowerCase().toCharArray();

        for (char anInput : input) {
            if (isVowel(anInput)) {
                counter++;
            }
        }
        System.out.printf("Vowels: %d", counter);
    }

    private static boolean isVowel(char c) {
        List<Character> vowelList = new ArrayList<>();
        vowelList.add('a');
        vowelList.add('e');
        vowelList.add('i');
        vowelList.add('o');
        vowelList.add('u');
        vowelList.add('y');

        return vowelList.contains(c);
    }
}
