package Excercise.StringProcessing;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P09_MatchFullName {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String regex = "[A-Z][a-z]+ [A-Z][a-z]+$";
        String text = scan.nextLine();

        while (!text.equals("end")) {
            if (Pattern.matches(regex, text)) {
                System.out.println(text);
            }
            text = scan.nextLine();
        }
    }
}
