package Lab.DataRepresentationAndManipulation;

import java.math.BigInteger;
import java.util.Scanner;

public class P04_RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(factorial(number));
    }

    private static long factorial(int number){
        if (number <= 1){
            return 1;
        }
        return number * factorial(number-1);
    }
//    private static BigInteger factorial(int number) {
//        BigInteger result = BigInteger.valueOf(number);
//        if (BigInteger.ONE.equals(BigInteger.valueOf(number))){
//            return BigInteger.ONE;
//        }
//        return result.multiply(factorial(number-1));
//    }
}
