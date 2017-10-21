package Excercise.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;

public class P04_SortStudents_Stream {
    public static void main(String[] args) {
        final String dataFile = "D:\\problems\\JavaAdvanced\\StudentData.txt";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(dataFile))) {
            br.lines()
                    .skip(1)
                    .map(line -> line.split("\\s+"))
                    .sorted(Comparator
                            .comparing((String[] x) -> x[2])
                            .thenComparing((x, y) -> y[1].compareTo(x[1]))
                    )
                    .map(x -> x[1] + " " + x[2])
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
