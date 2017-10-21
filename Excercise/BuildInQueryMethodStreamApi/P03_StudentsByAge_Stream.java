package Excercise.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P03_StudentsByAge_Stream {
    public static void main(String[] args) {
        final String dataFile = "D:\\problems\\JavaAdvanced\\StudentData.txt";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(dataFile))) {
            br.lines()
                    .skip(1)
                    .map(line -> line.split("\\s+"))
                    .filter(x -> Integer.parseInt(x[4]) >= 18 && Integer.parseInt(x[4]) <= 24)
                    .map(x -> x[1] + " " + x[2] + " " + x[4])
                    .forEachOrdered(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
