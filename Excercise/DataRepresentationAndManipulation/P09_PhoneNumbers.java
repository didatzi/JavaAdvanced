package Excercise.DataRepresentationAndManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09_PhoneNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String regex = "([A-Z](?:[a-zA-Z]+)?)([^a-zA-Z+]*[+]?[0-9]+[()/.\\- ]*[0-9]+(?:[()/.\\- ]+[0-9]+)*)";
        Map<String, String> phoneBook = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile(regex);
        StringBuilder text = new StringBuilder("");

        while (true) {
            String input = scan.readLine();
            if ("END".equals(input)) {
                break;
            }
            text.append(input);
        }

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String name = matcher.group(1);
            String phone = matcher.group(2);
            StringBuilder filteredPhone = new StringBuilder();

            for (int i = 0; i < phone.length(); i++) {
                try {
                    if (phone.charAt(i) == '+') {
                        filteredPhone.append("+");
                    }
                    byte digit = Byte.parseByte(phone.charAt(i) + "");
                    filteredPhone.append(digit);
                } catch (Exception ignored) {
                }
            }

            phoneBook.put(name, filteredPhone.toString());
        }

        if (phoneBook.isEmpty()) {
            System.out.println("<p>No matches!</p>");
        } else {
            StringBuilder result = new StringBuilder("<ol>");

            for (String s : phoneBook.keySet()) {
                result.append("<li><b>").append(s).append(":</b> ").append(phoneBook.get(s)).append("</li>");
            }

            result.append("</ol>");
            System.out.println(result);
        }
    }
}
