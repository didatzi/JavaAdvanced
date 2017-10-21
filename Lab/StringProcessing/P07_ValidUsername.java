package Lab.StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07_ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern =
                Pattern.compile("^[a-zA-Z0-9_-]{3,16}$");
        String text = scanner.nextLine();
        while (!text.equalsIgnoreCase("END")) {
            Matcher matcher = pattern.matcher(text);
            if (matcher.find())
                System.out.println("valid");
            else
                System.out.println("invalid");

            text = scanner.nextLine();
        }
    }
}
