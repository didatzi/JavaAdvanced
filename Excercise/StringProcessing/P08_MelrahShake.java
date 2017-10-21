package Excercise.StringProcessing;

import java.util.Scanner;

public class P08_MelrahShake {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = console.nextLine();
        String pattern = console.nextLine();

        while (text.length() > 0 && pattern.length() > 0) {
            int firstIndex = text.indexOf(pattern);
            int lastIndex = text.lastIndexOf(pattern);

            if (firstIndex != -1 && lastIndex != -1 && firstIndex != lastIndex) {
                StringBuilder sb = new StringBuilder();
                sb.append(text.substring(0, firstIndex));
                sb.append(text.substring(firstIndex + pattern.length(), lastIndex));
                sb.append(text.substring(lastIndex + pattern.length(), text.length()));

                text = sb.toString();

                int indexToBeRemoved = pattern.length() / 2;
                sb.setLength(0);
                sb.append(pattern).deleteCharAt(indexToBeRemoved);
                pattern = sb.toString();

                System.out.println("Shaked it.");
            } else {
                break;
            }
        }
        System.out.println("No shake.");
        System.out.println(text);
    }
}
