package Excercise.StringProcessing;

import java.util.Scanner;

public class P07_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        Double sum = 0.0;

        for (String anInput : input) {
            Character firstChar = anInput.charAt(0);
            Character lastChar = anInput.charAt(anInput.length() - 1);

            Double number = Double.parseDouble(anInput.substring(1, anInput.length() - 1));


            if (firstChar.toString().toUpperCase().equals(firstChar.toString()))  // upperCase
            {
                sum += number / (firstChar - 64);  // position of letter in english Alphabet
            } else  // lowerCase
            {
                Integer first = (int) (Character.toUpperCase(firstChar)) - 64;
                sum += number * first;
            }


            if (lastChar.toString().toUpperCase().equals(lastChar.toString()))  // upperCase
            {
                Integer last = lastChar - 64; // position of big letter in english Alphabet

                sum -= last;
            } else  // lowerCase
            {
                Integer last = lastChar - 96;  // position of small letter in english Alphabet
                sum += last;
            }

//            System.out.printf("%s%n", firstChar);
//            System.out.printf("%d\n", number);
//            System.out.printf("%s%n", lastChar);

        }
        System.out.printf("%.2f\n", sum);
    }
}
