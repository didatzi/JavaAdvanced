package Excercise.StringProcessing;

import java.util.Scanner;

public class P01_CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();
        String searchedText = scanner.nextLine().toLowerCase();
        int counter = 0;
        int index = text.indexOf(searchedText);

        while (index != -1)
        {
            counter++;
            index = text.indexOf(searchedText, index + 1);
        }
        System.out.println(counter);
    }
}
