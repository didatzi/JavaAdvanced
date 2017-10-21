package Excercise.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class P09_StudentsByEnrollmentYear {
    public static void main(String[] args) {
        final String dataFile = "D:\\problems\\JavaAdvanced\\StudentData.txt";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(dataFile))) {
            br.lines()
                    .skip(1)
                    .map(line -> line.split("\\s+"))
                    .collect(Collectors
                            .groupingBy(
                                    x -> "20" + x[0].substring(4) + ":",
                                    Collectors.mapping(x -> "-- " + x[1] + " " + x[2],
                                            Collectors.toCollection(TreeSet::new)
                                    )
                            )
                    )
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    .forEachOrdered(entry -> {
                        System.out.println(entry.getKey());
                        entry.getValue().forEach(System.out::println);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
