package Excercise.FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Predicate;

public class P07_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> checkNames = n -> n.length() <= number;
        StringBuilder namesBuilder = new StringBuilder();
        for (String name:names) {
            if (checkNames.test(name)){
                namesBuilder.append(name).append("\n");
            }
        }
        System.out.print(namesBuilder.toString());
    }
}
