package Excercise.FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class P02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        Consumer<String> printWordTitle = word -> System.out.println("Sir " + word);
        for (String name : names) {
            printWordTitle.accept(name);
        }
    }
}
