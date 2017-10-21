package Excercise.ObjectsClassesAndCollections;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_BalancedParentheses2 { // 100/100
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (isBalanced(input)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isBalanced(String input) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int index = 0; index < input.length(); index++) {
            char parenthesis = input.charAt(index);
            if (parenthesis == '[' || parenthesis == '(' || parenthesis == '{') {
                stack.addFirst(parenthesis);
            } else {
                if (!stack.isEmpty()) {
                    char first = stack.pop();
                    if (first == '{') {
                        if (parenthesis != '}') {
                            return false;
                        }
                    } else if (first == '[') {
                        if (parenthesis != ']') {
                            return false;
                        }
                    } else if (first == '(') {
                        if (parenthesis != ')') {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
