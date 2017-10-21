package Lab.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class P02_UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> words = Arrays.asList(reader.readLine().split("\\s+"));
        words.stream().map(String::toUpperCase).forEach(s -> System.out.print(s + " "));
//        Arrays.stream(reader.readLine().split("\\s+"))
//                .map(String::toUpperCase)
//                .forEach(s -> System.out.print(s + " "));
    }
}
