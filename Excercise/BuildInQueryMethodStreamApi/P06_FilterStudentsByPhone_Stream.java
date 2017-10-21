package Excercise.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P06_FilterStudentsByPhone_Stream {
    public static void main(String[] args) {
        final String dataFile = "D:\\problems\\JavaAdvanced\\StudentData.txt";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(dataFile))) {
            br.lines()
                    .skip(1)
                    .map(line -> line.split("\\s+"))
                    .filter(x -> x[10].startsWith("02") || x[10].startsWith("+3592"))
                    .map(x -> x[1] + " " + x[2] + " " + x[10])
                    .forEachOrdered(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
