package Lab.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class P03_FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.asList(inputReader.readLine().split("\\s+"));
        HashSet<Character> letters  = new HashSet<>();
        Stream.of(inputReader.readLine().split("\\s+")).map(s -> s.toUpperCase().charAt(0)).forEach(letters::add);

        Optional<String> first = names
                .stream()
                .filter(s -> letters.contains(s.charAt(0)))
                .sorted()
                .findFirst();
        if (first.isPresent()){
            System.out.println(first.get());
        }else{
            System.out.println("No match");
        }
    }
}
