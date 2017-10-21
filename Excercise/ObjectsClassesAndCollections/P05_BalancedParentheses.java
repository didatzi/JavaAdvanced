package Excercise.ObjectsClassesAndCollections;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_BalancedParentheses { // 75/100
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        ArrayDeque<Character> expression = new ArrayDeque<>();
        for (char ch : input) {
            expression.add(ch);
        }

        for (int i = 0; i < input.length / 2; i++) {

            char first = expression.pollFirst();
            char last = expression.pollLast();
            boolean isBalanced = (first == '{' && last == '}')
                    || (first == '[' && last == ']')
                    || (first == '(' && last == ')');

            if (!isBalanced) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
