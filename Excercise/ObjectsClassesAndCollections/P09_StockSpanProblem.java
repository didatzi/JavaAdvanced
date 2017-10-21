package Excercise.ObjectsClassesAndCollections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P09_StockSpanProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine());
        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.valueOf(scanner.nextLine());
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(calculateSpan(prices, sb));
    }

    private static StringBuilder calculateSpan(int[] prices, StringBuilder sb) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] spans = new int[prices.length];

        spans[0] = 1;
        sb.append(spans[0]).append("\n");
        stack.push(0);

        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            spans[i] = (stack.isEmpty())? (i + 1) : (i - stack.peek());
            stack.push(i);
            sb.append(spans[i]).append("\n");
        }
        return sb;
    }
}
