package Excercise.StringProcessing;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P10_MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        String regex = "\\+359([ -])2\\1\\d{3}\\1\\d{4}$";

        while (!text.equals("end")) {
            if (Pattern.matches(regex, text)) {
                System.out.println(text);
            }
            text = scan.nextLine();
        }
    }
}
