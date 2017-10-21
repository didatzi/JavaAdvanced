package Lab.StringProcessing;

import java.util.Scanner;

public class P03_ParseTags_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder print = new StringBuilder(input);
        for (int i = 0; i < print.length() - 1; i++) {
            if (print.charAt(i) == print.charAt(i + 1)) {
                print.deleteCharAt(i);
                i--;
            }
        }
        System.out.println(print);
    }
}
