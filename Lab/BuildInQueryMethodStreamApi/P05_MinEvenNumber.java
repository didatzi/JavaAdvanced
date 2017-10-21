package Lab.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.stream.Stream;

public class P05_MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> input = Stream.of(inputReader.readLine().split("\\s+"));
//      (x, y) -> x.compareTo(y);  == Double::compareTo
        Optional<Double> number = input.filter(s -> !s.isEmpty()).map(Double::valueOf).filter(n -> n % 2 == 0).min(Double::compareTo);
        if (number.isPresent()){
            System.out.printf("%.2f", number.get());
        }else {
            System.out.println("No match");
        }
    }
}
