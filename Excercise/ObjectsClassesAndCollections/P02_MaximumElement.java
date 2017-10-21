package Excercise.ObjectsClassesAndCollections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int index = 0; index < numberOfCommands; index++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]){
                case "1":
                    Integer number = Integer.parseInt(tokens[1]);
                    numbers.push(number);
                    break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(numbers));
                    break;
            }
        }
    }
}
