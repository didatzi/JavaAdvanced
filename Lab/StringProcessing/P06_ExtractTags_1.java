package Lab.StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06_ExtractTags_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        StringBuilder text = new StringBuilder();
        while (!line.equals("END")) {
            text.append(line);
            line = scanner.nextLine();
        }

        Pattern pattern = Pattern.compile("<.+?>");
        Matcher matcher = pattern.matcher(text.toString());

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
