package Lab.IntroToJava;

import java.util.Scanner;

public class P04_Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        if (firstName.isEmpty()) {
            firstName ="*****";
        }
        if (lastName.isEmpty()){
            lastName = lastName.replace("", "*****");
        }
        System.out.printf("Hello, %s %s!", firstName, lastName);
    }
}
