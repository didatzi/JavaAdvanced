package Lab.ObjectsClassesAndCollections;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String name:names) {
            queue.offer(name);
        }
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            }
            else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());

    }

    private static boolean isPrime(int number) {
        if (number == 0 || number == 1)
        {
            return false;
        }
        double maxNum = (int) Math.sqrt(number);
        for (int currentNum = 2; currentNum <= maxNum; currentNum++)
        {
            if (number % currentNum == 0)
            {
                return false;
            }
        }
        return true;
    }
}
