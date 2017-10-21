package Lab.BuildInQueryMethodStreamApi;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class P06_FindAndSumIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Optional<Integer> input = Stream
                .of(scanner.nextLine().split("\\s+"))
                .filter(s -> isInteger(s))
                .map(Integer::valueOf)
                .reduce((x, y) -> x+y);

        if (input.isPresent()){
            System.out.println(input.get());
        }else{
            System.out.println("No match");
        }
    }

    private static boolean isInteger(String element) {
        boolean isNumber = true;
        try{
           int number = Integer.parseInt(element);
       }catch (Exception e){
           isNumber = false;
       }
       return isNumber;
    }
}
