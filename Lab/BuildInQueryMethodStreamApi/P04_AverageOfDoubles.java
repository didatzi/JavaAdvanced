package Lab.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class P04_AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

//       String[] input = inputReader.readLine().split("\\s+");
//       DoubleStream numbers = Arrays.stream(input).filter(s->!s.isEmpty()).mapToDouble(Double::parseDouble);
//       OptionalDouble average = numbers.average();

        OptionalDouble average = Arrays
                .stream(inputReader.readLine().split("\\s+"))
                .filter(s -> !s.isEmpty())
                .mapToDouble(Double::parseDouble)
                .average();
        if (average.isPresent()){
            System.out.printf("%.2f", average.getAsDouble());
        }
        else{
            System.out.println("No match");
        }
    }
}
